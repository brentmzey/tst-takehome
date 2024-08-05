package io.brentzey.takehome.logging

import org.slf4j.{LoggerFactory, Logger => Slf4jLogger}
import org.slf4j.spi.{LocationAwareLogger => Slf4jLocationAwareLogger}

import java.util.UUID

object Logger {

  lazy val CRITICAL_ERROR_ID: UUID = UUID.fromString("d45bb64a-c4b0-41a4-95dc-d5ef420733c1")

  def apply(clazz: Class[_]): Logger = {
    require(clazz != null, "clazz must not be null!")
    logger(LoggerFactory getLogger clazz)
  }

  def apply(name: String): Logger = {
    require(name != null, "Logger name must not be null!")
    logger(LoggerFactory getLogger name)
  }

  def criticalErrorMsg(msg: String): String = {
    s"CRITICAL ERROR (ID: ${Logger.CRITICAL_ERROR_ID}) - $msg"
  }

  private def logger(slf4jLogger: Slf4jLogger): Logger = slf4jLogger match {
    case locationAwareLogger: Slf4jLocationAwareLogger =>
      new DefaultLocationAwareLogger(locationAwareLogger)
    case _ =>
      new DefaultLogger(slf4jLogger)
  }
}

trait Logger {

  lazy val name = slf4jLogger.getName

  protected val slf4jLogger: Slf4jLogger

  def critical(msg: => String): Unit = {
    val criticalMsg = Logger.criticalErrorMsg(msg)
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(criticalMsg)
  }

  def critical(msg: => String, t: Throwable): Unit = {
    val criticalMsg = Logger.criticalErrorMsg(msg)
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(criticalMsg, t)
  }

  def error(msg: => String): Unit = {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg)
  }

  def error(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg, t)
  }

  def warn(msg: => String): Unit = {
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg)
  }

  def warn(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg, t)
  }

  def info(msg: => String): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg)
  }

  def info(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg, t)
  }

  def debug(msg: => String): Unit = {
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg)
  }

  def debug(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg, t)
  }

  def trace(msg: => String): Unit = {
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg)
  }

  def trace(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg, t)
  }
}

private[logging] final class DefaultLogger(override protected val slf4jLogger: Slf4jLogger) extends Logger

/**
 * Thin wrapper for a location aware SLF4J logger making use of by-name parameters to improve performance.
 *
 * This implementation delegates to a location aware logger. For those SLF4J adapters that implement this
 * interface, such as log4j and java.util.logging adapters, the code location reported will be that
 * of the caller instead of the wrapper.
 *
 * Hint: Use the Logger object to choose the correct implementation automatically.
 */
trait LocationAwareLogger extends Logger {
  import Slf4jLocationAwareLogger.{ERROR_INT, WARN_INT, INFO_INT, DEBUG_INT, TRACE_INT}

  override protected val slf4jLogger: Slf4jLocationAwareLogger

  /**
   * Get the wrapper class name for detection of the stackframe of the user
   * code calling into the log framework.
   * @return Fully qualified class name of the outermost logger wrapper class
   */
  protected val wrapperClassName: String

  override def critical(msg: => String): Unit = {
    val criticalMsg = Logger.criticalErrorMsg(msg)
    if (slf4jLogger.isErrorEnabled) log(ERROR_INT, criticalMsg)
  }

  override def critical(msg: => String, t: Throwable): Unit = {
    val criticalMsg = Logger.criticalErrorMsg(msg)
    if (slf4jLogger.isErrorEnabled) log(ERROR_INT, criticalMsg, t)
  }

  override def error(msg: => String): Unit = {
    if (slf4jLogger.isErrorEnabled) log(ERROR_INT, msg)
  }

  override def error(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isErrorEnabled) log(ERROR_INT, msg, t)
  }

  override def warn(msg: => String): Unit = {
    if (slf4jLogger.isWarnEnabled) log(WARN_INT, msg)
  }

  override def warn(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isWarnEnabled) log(WARN_INT, msg, t)
  }

  override def info(msg: => String): Unit = {
    if (slf4jLogger.isInfoEnabled) log(INFO_INT, msg)
  }

  override def info(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isInfoEnabled) log(INFO_INT, msg, t)
  }

  override def debug(msg: => String): Unit = {
    if (slf4jLogger.isDebugEnabled) log(DEBUG_INT, msg)
  }

  override def debug(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isDebugEnabled) log(DEBUG_INT, msg, t)
  }

  override def trace(msg: => String): Unit = {
    if (slf4jLogger.isTraceEnabled) log(TRACE_INT, msg)
  }

  override def trace(msg: => String, t: Throwable): Unit = {
    if (slf4jLogger.isTraceEnabled) log(TRACE_INT, msg, t)
  }

  private final def log(level: Int, msg: String, throwable: Throwable = null): Unit = {
    slf4jLogger.log(null, wrapperClassName, level, msg, null, throwable)
  }
}

private[logging] object DefaultLocationAwareLogger {
  private val WrapperClassName = classOf[DefaultLocationAwareLogger].getName
}

private[logging] final class DefaultLocationAwareLogger(override protected val slf4jLogger: Slf4jLocationAwareLogger)
  extends LocationAwareLogger {
  override protected val wrapperClassName = DefaultLocationAwareLogger.WrapperClassName
}
