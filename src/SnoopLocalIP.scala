package org.nlogo.extensions.snooper

import
  java.net.{ Inet4Address, InetAddress, NetworkInterface }

import
  org.nlogo.api.{ Argument, Context, DefaultReporter, Syntax }

object SnoopLocalIP extends DefaultReporter {

  override def getSyntax = Syntax.reporterSyntax(Syntax.StringType)

  override def report(args: Array[Argument], context: Context) : AnyRef = {
    if (!InetAddress.getLocalHost.isLoopbackAddress)
      InetAddress.getLocalHost.getHostAddress
    else {
      import scala.collection.JavaConverters._
      NetworkInterface.getNetworkInterfaces.asScala.toSeq flatMap {
        _.getInetAddresses.asScala.toSeq
      } collectFirst {
        case addr: Inet4Address if (!addr.isLoopbackAddress) => addr.getHostAddress
      } getOrElse Boolean.box(false)
    }
  }

}

