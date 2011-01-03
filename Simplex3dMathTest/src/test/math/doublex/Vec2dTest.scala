/*
 * Simplex3d, MathTest package
 * Copyright (C) 2009-2011, Simplex3d Team
 *
 * This file is part of Simplex3dMathTest.
 *
 * Simplex3dMathTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dMathTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package test.math.doublex

import org.scalatest._
import test.math.BooleanCombinations

import simplex3d.math._
import simplex3d.math.floatx._
import simplex3d.math.double._
import simplex3d.math.doublex.functions._


/**
 * @author Aleksey Nikiforov (lex)
 */
class Vec2dTest extends FunSuite {

  test("Clone") {
    var t: ReadVec2 = Vec2(1)
    assert(t.clone() ne t)
    assert(t.clone() == t)

    t = ConstVec2(1)
    assert(t.clone() eq t)
  }

  test("Factories") {
    def test(x: Double, y: Double, z: Double, w: Double) {
      var u: ReadVec2 = Vec2(x)
      expect(classOf[Vec2]) { u.getClass }
      expect(x) { u.x }
      expect(x) { u.y }

      u = ConstVec2(x)
      expect(classOf[ConstVec2]) { u.getClass }
      expect(x) { u.x }
      expect(x) { u.y }

      u = Vec2(x, y)
      expect(classOf[Vec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = Vec2(Vec2i(Int(x), Int(y)))
      expect(classOf[Vec2]) { u.getClass }
      expect(Int(x)) { u.x }
      expect(Int(y)) { u.y }

      u = Vec2(Vec3i(Int(x), Int(y), Int(z)))
      expect(classOf[Vec2]) { u.getClass }
      expect(Int(x)) { u.x }
      expect(Int(y)) { u.y }

      u = Vec2(Vec4i(Int(x), Int(y), Int(z), Int(w)))
      expect(classOf[Vec2]) { u.getClass }
      expect(Int(x)) { u.x }
      expect(Int(y)) { u.y }

      u = Vec2(Vec2f(Float(x), Float(y)))
      expect(classOf[Vec2]) { u.getClass }
      expect(Float(x)) { u.x }
      expect(Float(y)) { u.y }

      u = Vec2(Vec3f(Float(x), Float(y), Float(z)))
      expect(classOf[Vec2]) { u.getClass }
      expect(Float(x)) { u.x }
      expect(Float(y)) { u.y }

      u = Vec2(Vec4f(Float(x), Float(y), Float(z), Float(w)))
      expect(classOf[Vec2]) { u.getClass }
      expect(Float(x)) { u.x }
      expect(Float(y)) { u.y }

      u = Vec2(Vec2(Double(x), Double(y)))
      expect(classOf[Vec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = Vec2(Vec3(Double(x), Double(y), Double(z)))
      expect(classOf[Vec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = Vec2(Vec4(Double(x), Double(y), Double(z), Double(w)))
      expect(classOf[Vec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = ConstVec2(x, y)
      expect(classOf[ConstVec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = ConstVec2(ConstVec2i(Int(x), Int(y)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(Int(x)) { u.x }
      expect(Int(y)) { u.y }

      u = ConstVec2(Vec3i(Int(x), Int(y), Int(z)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(Int(x)) { u.x }
      expect(Int(y)) { u.y }

      u = ConstVec2(Vec4i(Int(x), Int(y), Int(z), Int(w)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(Int(x)) { u.x }
      expect(Int(y)) { u.y }

      u = ConstVec2(ConstVec2f(Float(x), Float(y)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(Float(x)) { u.x }
      expect(Float(y)) { u.y }

      u = ConstVec2(Vec3f(Float(x), Float(y), Float(z)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(Float(x)) { u.x }
      expect(Float(y)) { u.y }

      u = ConstVec2(Vec4f(Float(x), Float(y), Float(z), Float(w)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(Float(x)) { u.x }
      expect(Float(y)) { u.y }

      u = ConstVec2(ConstVec2(Double(x), Double(y)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = ConstVec2(Vec3(Double(x), Double(y), Double(z)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }

      u = ConstVec2(Vec4(Double(x), Double(y), Double(z), Double(w)))
      expect(classOf[ConstVec2]) { u.getClass }
      expect(x) { u.x }
      expect(y) { u.y }
    }

    test(2, 3, 4, 5)
    val eps = 1e-15
    test(2 + eps, 3 + eps, 4 + eps, 5 + eps)
  }

  test("Boolean factories") {
    BooleanCombinations.test { (x, y, z, w) =>
      var u: ReadVec2 = Vec2(Vec2b(x, y))
      expect(classOf[Vec2]) { u.getClass }
      expect(Double(x)) { u.x }
      expect(Double(y)) { u.y }

      u = Vec2(Vec3b(x, y, z))
      expect(classOf[Vec2]) { u.getClass }
      expect(Double(x)) { u.x }
      expect(Double(y)) { u.y }

      u = Vec2(Vec4b(x, y, z, w))
      expect(classOf[Vec2]) { u.getClass }
      expect(Double(x)) { u.x }
      expect(Double(y)) { u.y }

      var c: ReadVec2 = ConstVec2(Vec2b(x, y))
      expect(classOf[ConstVec2]) { c.getClass }
      expect(Double(x)) { c.x }
      expect(Double(y)) { c.y }
    }
  }

  test("Unapply") {
    val x = 1+1e-15; val y = 2+1e-15
    Vec2(x, y) match {
      case Vec2(ux, uy) =>
        if (ux != x || uy != y)
          throw new AssertionError()
    }
    ConstVec2(x, y) match {
      case Vec2(ux, uy) =>
        if (ux != x || uy != y)
          throw new AssertionError()
    }
  }

  test("Const conversions") {
    val x = 1d + 1e-15
    val y = 2d + 1e-15

    val t: ConstVec2 = Vec2(x, y)
    expect(classOf[ConstVec2]) { t.getClass }
    assert(Vec2(x, y) == t)

    var c: ConstVec2 = Vec2(x, y); var v = Vec2(3)
    expect(classOf[ConstVec2]) { c.getClass }
    v = c; assert(Vec2(x, y) == v)
    expect(classOf[Vec2]) { v.getClass }

    c = Vec2(5); v = Vec2(x, y)
    expect(classOf[Vec2]) { v.getClass }
    c = v; assert(Vec2(x, y) == c)
    expect(classOf[ConstVec2]) { c.getClass }
  }

  test("Equality methods") {
    val m = Vec2(4, 7)
    val c = ConstVec2(4, 7)

    assert(m == m)
    assert(m == c)
    assert(c == m)
    assert(c == c)

    assert(m.equals(c))
    assert(!m.equals(Nil))

    assert(Vec2(1, 2) != Vec2(9, 2))
    assert(Vec2(1, 2) != Vec2(1, 9))

    assert(Vec2(0) != Vec2b(false))

    assert(Vec2(1, 2) == Vec2i(1, 2))
    assert(Vec2(1, 2) != Vec2i(9, 2))
    assert(Vec2(1, 2) != Vec2i(1, 9))

    assert(Vec2(1, 2) == Vec2f(1, 2))
    assert(Vec2(1, 2) != Vec2f(9, 2))
    assert(Vec2(1, 2) != Vec2f(1, 9))
  }

  test("Indexed read") {
    val u = ConstVec2(3, 4)

    expect(3) { u(0) }
    expect(4) { u(1) }

    intercept[IndexOutOfBoundsException] {
      u(2)
    }
    intercept[IndexOutOfBoundsException] {
      u(-1)
    }
  }

  test("Indexed write") {
    val u = Vec2(3, 4)

    u(0) = 5
    assert(Vec2(5, 4) == u)

    u(1) = 6
    assert(Vec2(5, 6) == u)

    intercept[IndexOutOfBoundsException] {
      u(2) = 1
    }
    intercept[IndexOutOfBoundsException] {
      u(-1) = 1
    }
  }

  test("Setters") {
    val u = Vec2(0)

    u := Vec2(1, 2)
    expect(1) { u.x }
    expect(2) { u.y }
  }

  test("Const math") {
    val u = ConstVec2(7, 8)

    assert(+u eq u)

    assert(Vec2(-7, -8) == -u)

    assert(Vec2(14, 16) == u*2)
    assert(Vec2(3.5, 4) == u/2)

    assert(Vec2(9, 10) == u + 2)
    assert(Vec2(5, 6) == u - 2)

    val v = ConstVec2(2, 4)

    assert(Vec2(9, 12) == u + v)
    assert(Vec2(5, 4) == u - v)
    assert(Vec2(14, 32) == u*v)
    assert(Vec2(3.5, 2) == u/v)

    val m2 = ConstMat2(2, 4, 3, 5)
    assert(Vec2(46, 61) == u*m2)

    val m2x3 = ConstMat2x3(2, 4, 3, 5, 6, 7)
    assert(Vec3(46, 61, 98) == u*m2x3)

    val m2x4 = ConstMat2x4(2, 4, 3, 5, 6, 7, 8, 9)
    assert(Vec4(46, 61, 98, 128) == u*m2x4)
  }

  test("Mutable math") {
    val u = Vec2(0)
    val i = ConstVec2(2, 3)

    u := i; u *= 2; assert(Vec2(4, 6) == u)
    u := i; u /= 2; assert(Vec2(1, 1.5) == u)

    u := i; u += 2; assert(Vec2(4, 5) == u)
    u := i; u -= 2; assert(Vec2(0, 1) == u)

    u := i; u += Vec2(3, 4); assert(Vec2(5, 7) == u)
    u := i; u += u; assert(Vec2(4, 6) == u)
    u := i; u -= Vec2(2, 3); assert(Vec2(0, 0) == u)
    u := i; u -= u; assert(Vec2(0, 0) == u)

    u := i; u *= Vec2(5, 10); assert(Vec2(10, 30) == u)
    u := i; u *= u; assert(Vec2(4, 9) == u)
    u := i; u /= Vec2(2, 6); assert(Vec2(1, 0.5) == u)
    u := i; u /= u; assert(Vec2(1, 1) == u)

    u := Vec2(7, 8)
    u *= ConstMat2(2, 4, 3, 5)
    assert(Vec2(46, 61) == u)
  }

}