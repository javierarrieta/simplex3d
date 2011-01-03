/*
 * Simplex3d, DoubleMath module
 * Copyright (C) 2009-2011, Simplex3d Team
 *
 * This file is part of Simplex3dMath.
 *
 * Simplex3dMath is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dMath is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package simplex3d.math.doublex

import simplex3d.math._


/**
 * Glue code to promote integer types to double types.
 *
 * @author Aleksey Nikiforov (lex)
 */
final class IntPromoter(val value: Double) {
  // Veci to Vecd promotion
  def *(u: AnyVec2[Int]) = new Vec2d(value*u.dx, value*u.dy)
  def /(u: AnyVec2[Int]) = new Vec2d(value/u.dx, value/u.dy)
  def +(u: AnyVec2[Int]) = new Vec2d(value + u.dx, value + u.dy)
  def -(u: AnyVec2[Int]) = new Vec2d(value - u.dx, value - u.dy)

  def *(u: AnyVec3[Int]) = new Vec3d(value*u.dx, value*u.dy, value*u.dz)
  def /(u: AnyVec3[Int]) = new Vec3d(value/u.dx, value/u.dy, value/u.dz)
  def +(u: AnyVec3[Int]) = new Vec3d(value + u.dx, value + u.dy, value + u.dz)
  def -(u: AnyVec3[Int]) = new Vec3d(value - u.dx, value - u.dy, value - u.dz)

  def *(u: AnyVec4[Int]) = new Vec4d(value*u.dx, value*u.dy, value*u.dz, value*u.dw)
  def /(u: AnyVec4[Int]) = new Vec4d(value/u.dx, value/u.dy, value/u.dz, value/u.dw)
  def +(u: AnyVec4[Int]) = new Vec4d(value + u.dx, value + u.dy, value + u.dz, value + u.dw)
  def -(u: AnyVec4[Int]) = new Vec4d(value - u.dx, value - u.dy, value - u.dz, value - u.dw)
}