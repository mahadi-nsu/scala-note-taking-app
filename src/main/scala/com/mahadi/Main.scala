package com.mahadi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import com.mahadi.routes.NoteRoutes

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    // Initialize the ActorSystem
    implicit val system: ActorSystem = ActorSystem("note-taking-app")
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    // Combine all routes
    val routes = NoteRoutes.routes

    // Start the HTTP server
    val bindingFuture = Http().newServerAt("localhost", 8080).bind(routes)

    println("Server started at http://localhost:8080/")
    println("Press RETURN to stop...")

    // Wait for user input to terminate
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
