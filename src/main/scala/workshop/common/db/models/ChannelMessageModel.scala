package workshop.common.db.models

import java.time.Instant

import workshop.common.db.CustomMapping

trait ChannelMessageModel extends DatabaseModel with CustomMapping {
  import profile.api._

  final case class ChannelMessage(id: Int, channel: String, userLogin: String, text: String, createdAt: Instant)

  class ChannelMessages(tag: Tag) extends Table[ChannelMessage](tag, "channel_message") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def login = column[String]("login")
    def channel = column[String]("channel")
    def text = column[String]("text")
    def createdAt = column[Instant]("created_at")

    override def * = (id, channel, login, text, createdAt) <> (ChannelMessage.tupled, ChannelMessage.unapply _)
  }

  val channelMessages = TableQuery[ChannelMessages]
}