package io.brentzey.takehome.logging

trait Logging {
  protected[logging] lazy val logger = Logger(this.getClass)
}
