package workshop.services

import slick.jdbc.{JdbcBackend, JdbcProfile}
import workshop.Channel
import workshop.common.concurrent.ApplicationContext
import workshop.common.db.EntityIsNotExistsException
import workshop.common.db.models.ChannelModel

import scala.concurrent.Future

trait ChannelService {
  def createChannel(name: String, description: String): Future[Channel]
  def close(channel: String): Future[Unit]
}

class ChannelServiceImpl(val profile: JdbcProfile, db: JdbcBackend.Database) extends ChannelService with ApplicationContext with ChannelModel {
  import profile.api._

  override def close(name: String): Future[Unit] = {
    db.run {
      channels.filter(_.name === name.bind).map(_.archived).update(true)
    }.map {
      case 1 => ()
      case _ => throw new EntityIsNotExistsException(s"Cannot find channel with name=$name")
    }
  }

  override def createChannel(name: String, description: String): Future[Channel] = {
    val channel = Channel(name, Some(description), archived = false)
    db.run(channels += channel).map(_ => channel)
  }
}
