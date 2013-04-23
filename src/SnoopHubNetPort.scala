package org.nlogo.extensions.snooper

import
  org.nlogo.{ api, app, hubnet },
    api.{ Argument, Context, DefaultReporter, Syntax },
    app.App,
    hubnet.server.HubNetManager

object SnoopHubNetPort extends DefaultReporter {
  override def getSyntax = Syntax.reporterSyntax(Syntax.StringType)
  override def report(args: Array[Argument], context: Context) : AnyRef = {
    val InvalidPort = Boolean.box(false)
    val workspace   = App.app.workspace
    if (workspace.hubNetRunning())
      workspace.hubnetManager match {
        case manager: HubNetManager => Double.box(manager.connectionManager.port)
        case _                      => InvalidPort
      }
    else
      InvalidPort
  }
}

