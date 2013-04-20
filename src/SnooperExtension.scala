package org.nlogo.extensions.snooper

import
  org.nlogo.api.{ Argument, Context, DefaultClassManager, DefaultReporter, PrimitiveManager, Syntax }

class SnooperExtension extends DefaultClassManager {

  def load(primitiveManager: PrimitiveManager) {
    primitiveManager.addPrimitive("snoop", Snoop)
  }

  object Snoop extends DefaultReporter {
    import java.net.InetAddress
    override def getSyntax = Syntax.reporterSyntax(Syntax.StringType)
    override def report(args: Array[Argument], context: Context) : AnyRef = {
      InetAddress.getLocalHost.getHostAddress
    }
  }

}

