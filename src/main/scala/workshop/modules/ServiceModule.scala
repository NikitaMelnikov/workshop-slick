package workshop.modules

import com.softwaremill.macwire._
import workshop.services.{ChannelService, ChannelServiceImpl, UserService, UserServiceImpl}

trait ServiceModule { _: DatabaseModule =>
  lazy val userService: UserService = wire[UserServiceImpl]
  lazy val channelService: ChannelService = wire[ChannelServiceImpl]
}
