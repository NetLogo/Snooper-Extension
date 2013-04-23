package org.nlogo.extensions.snooper

import
  org.nlogo.api.{ DefaultClassManager, PrimitiveManager }

class SnooperExtension extends DefaultClassManager {
  def load(primitiveManager: PrimitiveManager) {
    primitiveManager.addPrimitive("local-ip", SnoopLocalIP)
  }
}

