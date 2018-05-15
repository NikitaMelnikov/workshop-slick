package workshop.server.json

import java.time.Instant

import tethys._
import tethys.derivation.semiauto._
import workshop.{Channel, Message, User}
import workshop.server.controllers.ChannelController._
import workshop.server.controllers.UserController.{ChangeUserStatusRequest, ChangeUserStatusResponse, CreateUserRequest, CreateUserResponse}

trait ApplicationProtocol {
  implicit val instantJsonReader: JsonReader[Instant] = JsonReader.stringReader.map(Instant.parse)
  implicit val instantJsonWriter: JsonWriter[Instant] = JsonWriter.stringWriter.contramap(_.toString)

  implicit val userJsonReader: JsonReader[User] = jsonReader[User]
  implicit val userJsonWriter: JsonWriter[User] = jsonWriter[User]

  implicit val messageJsonWriter: JsonWriter[Message] = jsonWriter[Message]

  implicit val channelJsonWriter: JsonWriter[Channel] = jsonWriter[Channel]

  implicit val createUserRequestJsonReader: JsonReader[CreateUserRequest] = jsonReader[CreateUserRequest]
  implicit val createUserRequestJsonWriter: JsonWriter[CreateUserRequest] = jsonWriter[CreateUserRequest]

  implicit val createUserResponseJsonReader: JsonReader[CreateUserResponse] = jsonReader[CreateUserResponse]
  implicit val createUserResponseJsonWriter: JsonWriter[CreateUserResponse] = jsonWriter[CreateUserResponse]

  implicit val changeUserStatusRequestJsonReader: JsonReader[ChangeUserStatusRequest] = jsonReader[ChangeUserStatusRequest]
  implicit val changeUserStatusRequestJsonWriter: JsonWriter[ChangeUserStatusRequest] = jsonWriter[ChangeUserStatusRequest]

  implicit val changeUserStatusResponseJsonReader: JsonReader[ChangeUserStatusResponse] = jsonReader[ChangeUserStatusResponse]
  implicit val changeUserStatusResponseJsonWriter: JsonWriter[ChangeUserStatusResponse] = jsonWriter[ChangeUserStatusResponse]

  implicit val createChannelRequestJsonReader: JsonReader[CreateChannelRequest] = jsonReader[CreateChannelRequest]
  implicit val createChannelResponseJsonWriter: JsonWriter[CreateChannelResponse] = jsonWriter[CreateChannelResponse]

  implicit val getChannelResponseJsonWriter: JsonWriter[GetChannelResponse] = jsonWriter[GetChannelResponse]

  implicit val closeChannelResponseJsonWriter: JsonWriter[CloseChannelResponse] = jsonWriter[CloseChannelResponse]

  implicit val joinChannelRequestJsonReader: JsonReader[JoinChannelRequest] = jsonReader[JoinChannelRequest]
  implicit val joinChannelResponseJsonWriter: JsonWriter[JoinChannelResponse] = jsonWriter[JoinChannelResponse]

  implicit val sendMessageToChannelRequestJsonReader: JsonReader[SendMessageToChannelRequest] = jsonReader[SendMessageToChannelRequest]
  implicit val sendMessageToChannelResponseJsonWriter: JsonWriter[SendMessageToChannelResponse] = jsonWriter[SendMessageToChannelResponse]

  implicit val renderChannelResponseJsonWriter: JsonWriter[RenderChannelResponse] = jsonWriter[RenderChannelResponse]
}
