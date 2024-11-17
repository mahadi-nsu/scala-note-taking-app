package com.mahadi.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.mahadi.services.NoteService
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._

object NoteRoutes {
  val routes: Route = pathPrefix("notes") {
    pathEndOrSingleSlash {
      get {
        complete(NoteService.getAllNotes)
      }
    }
  }
}

