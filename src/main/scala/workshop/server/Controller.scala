package workshop.server

import java.time.Instant

import akka.http.scaladsl.marshalling.ToResponseMarshaller
import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.unmarshalling.{FromStringUnmarshaller, Unmarshaller}
import workshop.common.concurrent.ApplicationContext
import workshop.server.json.{ApplicationProtocol, TethysSupport}

import scala.concurrent.Future

trait Controller extends ApplicationContext with TethysSupport with ApplicationProtocol with Directives {
  implicit val fromStringInstantUnmarshaller: FromStringUnmarshaller[Instant] = Unmarshaller.strict[String, Instant](Instant.parse)

  def routes: Route

  implicit def futureToRoute[A](f: Future[A])(implicit toResponseMarshaller: ToResponseMarshaller[A]): Route = complete(f)
}