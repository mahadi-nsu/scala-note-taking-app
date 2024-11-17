package com.mahadi.services

import com.mahadi.models.Note
import scala.collection.mutable

object NoteService {
  private val notes = mutable.Map[String, Note]()

  def getAllNotes: Seq[Note] = notes.values.toSeq
  def addNote(note: Note): Unit = notes += (note.id -> note)
}

