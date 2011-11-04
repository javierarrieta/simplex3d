/*
 * Simplex3dEngine - Core Module
 * Copyright (C) 2011, Aleksey Nikiforov
 *
 * This file is part of Simplex3dEngine.
 *
 * Simplex3dEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package simplex3d.engine.graphics

import simplex3d.engine.common._


trait ReflectGeometry extends Geometry {
  
  private[this] var _attributeNames: ReadArray[String] = null
  private[this] var _attributes: ReadArray[UncheckedAttributes] = null
  
  private[this] var initialized = false 
  protected final def reflect(clazz: Class[_]) {
    if (clazz != this.getClass) return // Allows correct sub-classing.
    if (initialized) return
    
    val (an, av) = FieldReflection.getValueMap(
      this, classOf[UncheckedAttributes], Nil, ReflectGeometry.AttributesBlacklist
    )
    _attributeNames = an
    _attributes = av
    
    initialized = true
  }
  
  override def attributeNames: ReadArray[String] = _attributeNames
  override def attributes: ReadArray[UncheckedAttributes] = _attributes
}

object ReflectGeometry {
  private val AttributesBlacklist = List("indices")
}
