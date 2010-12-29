/*
 * Simplex3d, MathTest package
 * Copyright (C) 2010, Simplex3d Team
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

package test.math

import org.scalatest._
import simplex3d.math._
import simplex3d.math.CoreMath._


/**
 * @author Aleksey Nikiforov (lex)
 */
class CoreMathTest extends FunSuite {

  test("Casting") {
    val t0: Boolean = false
    val i0: Int = 0
    val f0: Float = 0
    val d0: Double = 0

    val t1: Boolean = true
    val i1: Int = 1
    val f1: Float = 1
    val d1: Double = 1

    val i2: Int = 2
    val f2: Float = 2
    val d2: Double = 2

    val i3: Int = -1
    val f3: Float = -1
    val d3: Double = -1

    assert(toBool(t1).isInstanceOf[Boolean])
    assert(toBool(i1).isInstanceOf[Boolean])
    assert(toBool(f1).isInstanceOf[Boolean])
    assert(toBool(d1).isInstanceOf[Boolean])

    assert(toBool(t1))
    assert(toBool(i1))
    assert(toBool(f1))
    assert(toBool(d1))

    assert(toBool(i2))
    assert(toBool(f2))
    assert(toBool(d2))

    assert(toBool(i3))
    assert(toBool(f3))
    assert(toBool(d3))

    assert(!toBool(t0))
    assert(!toBool(i0))
    assert(!toBool(f0))
    assert(!toBool(d0))

    assert(toInt(t1).isInstanceOf[Int])
    assert(toInt(i1).isInstanceOf[Int])
    assert(toInt(f1).isInstanceOf[Int])
    assert(toInt(d1).isInstanceOf[Int])

    assert(toInt(t1) == i1)
    assert(toInt(i1) == i1)
    assert(toInt(f1) == i1)
    assert(toInt(d1) == i1)

    assert(toInt(t0) == i0)
    assert(toInt(i0) == i0)
    assert(toInt(f0) == i0)
    assert(toInt(d0) == i0)

    assert(toFloat(t1).isInstanceOf[Float])
    assert(toFloat(i1).isInstanceOf[Float])
    assert(toFloat(f1).isInstanceOf[Float])
    assert(toFloat(d1).isInstanceOf[Float])

    assert(toFloat(t1) == f1)
    assert(toFloat(i1) == f1)
    assert(toFloat(f1) == f1)
    assert(toFloat(d1) == f1)

    assert(toFloat(t0) == f0)
    assert(toFloat(i0) == f0)
    assert(toFloat(f0) == f0)
    assert(toFloat(d0) == f0)

    assert(toDouble(t1).isInstanceOf[Double])
    assert(toDouble(i1).isInstanceOf[Double])
    assert(toDouble(f1).isInstanceOf[Double])
    assert(toDouble(d1).isInstanceOf[Double])

    assert(toDouble(t1) == d1)
    assert(toDouble(i1) == d1)
    assert(toDouble(f1) == d1)
    assert(toDouble(d1) == d1)

    assert(toDouble(t0) == d0)
    assert(toDouble(i0) == d0)
    assert(toDouble(f0) == d0)
    assert(toDouble(d0) == d0)
  }

  test("Boolean functions") {
    BooleanCombinations.test { (x, y, z, w) =>
      assert(any(Vec2b(x, y)) == (x || y))
      assert(all(Vec2b(x, y)) == (x && y))
      assert(not(Vec2b(x, y)) == Vec2b(!x, !y))

      assert(any(Vec3b(x, y, z)) == (x || y || z))
      assert(all(Vec3b(x, y, z)) == (x && y && z))
      assert(not(Vec3b(x, y, z)) == Vec3b(!x, !y, !z))

      assert(any(Vec4b(x, y, z, w)) == (x || y || z || w))
      assert(all(Vec4b(x, y, z, w)) == (x && y && z && w))
      assert(not(Vec4b(x, y, z, w)) == Vec4b(!x, !y, !z, !w))
    }
  }


  val random = new java.util.Random
  import random._

  test("Int functions") {
    expect(0) { abs(0) }
    expect(1) { abs(-1) }
    expect(1) { abs(1) }

    expect(0) { sign(0) }
    expect(-1){ sign(-1)}
    expect(1) { sign(1) }

    expect(2) { min(2, 3) }
    expect(3) { min(4, 3) }

    expect(3) { max(2, 3) }
    expect(4) { max(4, 3) }

    expect(10) { clamp(5, 10, 20) }
    expect(15) { clamp(15, 10, 20) }
    expect(20) { clamp(25, 10, 20) }
  }

  val testData = {
    (0, 0, 0, 0,
     0, 0, 0, 0,
     0, 0, 0, 0) ::
    (-1, -1, -1, -1,
     0, 0, 0, 0,
     0, 0, 0, 0) ::
    (1, 1, 1, 1,
     0, 0, 0, 0,
     0, 0, 0, 0) ::
    (5, 5, 5, 5,
     10, 10, 10, 10,
     20, 20, 20, 20) ::
    (10, 10, 10, 10,
     10, 10, 10, 10,
     20, 20, 20, 20) ::
    (15, 15, 15, 15,
     10, 10, 10, 10,
     20, 20, 20, 20) ::
    (20, 20, 20, 20,
     10, 10, 10, 10,
     20, 20, 20, 20) ::
    (25, 25, 25, 25,
     10, 10, 10, 10,
     20, 20, 20, 20) ::
    Nil
  }

  test("Vec2i functions") {
    def test(x: Int, y: Int, r: Int, g: Int, s: Int, t: Int) {
      expect(Vec2i(abs(x), abs(y))) { abs(Vec2i(x, y)) }
      expect(Vec2i(sign(x), sign(y))) { sign(Vec2i(x, y)) }

      expect(Vec2i(min(x, s), min(y, s))) { min(Vec2i(x, y), s) }
      expect(Vec2i(min(x, r), min(y, g))) {
        min(Vec2i(x, y), Vec2i(r, g))
      }
      expect(Vec2i(max(x, s), max(y, s))) { max(Vec2i(x, y), s) }
      expect(Vec2i(max(x, r), max(y, g))) {
        max(Vec2i(x, y), Vec2i(r, g))
      }

      expect(Vec2i(clamp(x, s, t), clamp(y, s, t))) {
        clamp(Vec2i(x, y), s, t)
      }
      expect(Vec2i(clamp(x, r, s), clamp(y, g, t))) {
        clamp(Vec2i(x, y), Vec2i(r, g), Vec2i(s, t))
      }

      expect(Vec2b(x < r, y < g)) {
        lessThan(Vec2i(x, y), Vec2i(r, g))
      }
      expect(Vec2b(x <= r, y <= g)) {
        lessThanEqual(Vec2i(x, y), Vec2i(r, g))
      }
      expect(Vec2b(x > r, y > g)) {
        greaterThan(Vec2i(x, y), Vec2i(r, g))
      }
      expect(Vec2b(x >= r, y >= g)) {
        greaterThanEqual(Vec2i(x, y), Vec2i(r, g))
      }
      expect(Vec2b(x == r, y == g)) {
        equal(Vec2i(x, y), Vec2i(r, g))
      }
      expect(Vec2b(x != r, y != g)) {
        notEqual(Vec2i(x, y), Vec2i(r, g))
      }
    }

    for ((x, y, _, _, r, g, _, _, s, t, _, _) <- testData) {
      test(x, y,
         r, g,
         s, t)
    }

    setSeed(1)
    for (i <- 0 until 1000) {
      test(nextInt, nextInt,
         nextInt, nextInt,
         nextInt, nextInt)
    }
  }

  test("Vec3i functions") {
    def test(x: Int, y: Int, z: Int,
         r: Int, g: Int, b: Int,
         s: Int, t: Int, p: Int)
    {
      expect(Vec3i(abs(x), abs(y), abs(z))) {
        abs(Vec3i(x, y, z))
      }
      expect(Vec3i(sign(x), sign(y), sign(z))) {
        sign(Vec3i(x, y, z))
      }

      expect(Vec3i(min(x, s), min(y, s), min(z, s))) {
        min(Vec3i(x, y, z), s)
      }
      expect(Vec3i(min(x, r), min(y, g), min(z, b))) {
        min(Vec3i(x, y, z), Vec3i(r, g, b))
      }
      expect(Vec3i(max(x, s), max(y, s), max(z, s))) {
        max(Vec3i(x, y, z), s)
      }
      expect(Vec3i(max(x, r), max(y, g), max(z, b))) {
        max(Vec3i(x, y, z), Vec3i(r, g, b))
      }

      expect(Vec3i(clamp(x, s, t), clamp(y, s, t), clamp(z, s, t))) {
        clamp(Vec3i(x, y, z), s, t)
      }
      expect(Vec3i(clamp(x, r, s), clamp(y, g, t), clamp(z, b, p))) {
        clamp(Vec3i(x, y, z), Vec3i(r, g, b), Vec3i(s, t, p))
      }

      expect(Vec3b(x < r, y < g, z < b)) {
        lessThan(Vec3i(x, y, z), Vec3i(r, g, b))
      }
      expect(Vec3b(x <= r, y <= g, z <= b)) {
        lessThanEqual(Vec3i(x, y, z), Vec3i(r, g, b))
      }
      expect(Vec3b(x > r, y > g, z > b)) {
        greaterThan(Vec3i(x, y, z), Vec3i(r, g, b))
      }
      expect(Vec3b(x >= r, y >= g, z >= b)) {
        greaterThanEqual(Vec3i(x, y, z), Vec3i(r, g, b))
      }
      expect(Vec3b(x == r, y == g, z == b)) {
        equal(Vec3i(x, y, z), Vec3i(r, g, b))
      }
      expect(Vec3b(x != r, y != g, z != b)) {
        notEqual(Vec3i(x, y, z), Vec3i(r, g, b))
      }
    }

    for ((x, y, z, _, r, g, b, _, s, t, p, _) <- testData) {
      test(x, y, z,
         r, g, b,
         s, t, p)
    }

    setSeed(1)
    for (i <- 0 until 1000) {
      test(nextInt, nextInt, nextInt,
         nextInt, nextInt, nextInt,
         nextInt, nextInt, nextInt)
    }
  }

  test("Vec4i functions") {
    def test(x: Int, y: Int, z: Int, w: Int,
         r: Int, g: Int, b: Int, a: Int,
         s: Int, t: Int, p: Int, q: Int)
    {
      expect(Vec4i(abs(x), abs(y), abs(z), abs(w))) {
        abs(Vec4i(x, y, z, w))
      }
      expect(Vec4i(sign(x), sign(y), sign(z), sign(w))) {
        sign(Vec4i(x, y, z, w))
      }

      expect(Vec4i(min(x, s), min(y, s), min(z, s), min(w, s))) {
        min(Vec4i(x, y, z, w), s)
      }
      expect(Vec4i(min(x, r), min(y, g), min(z, b), min(w, a))) {
        min(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
      expect(Vec4i(max(x, s), max(y, s), max(z, s), max(w, s))) {
        max(Vec4i(x, y, z, w), s)
      }
      expect(Vec4i(max(x, r), max(y, g), max(z, b), max(w, a))) {
        max(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }

      expect(Vec4i(clamp(x, s, t), clamp(y, s, t),
             clamp(z, s, t), clamp(w, s, t)))
      {
        clamp(Vec4i(x, y, z, w), s, t)
      }
      expect(Vec4i(clamp(x, r, s), clamp(y, g, t),
             clamp(z, b, p), clamp(w, a, q)))
      {
        clamp(Vec4i(x, y, z, w), Vec4i(r, g, b, a), Vec4i(s, t, p, q))
      }

      expect(Vec4b(x < r, y < g, z < b, w < a)) {
        lessThan(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
      expect(Vec4b(x <= r, y <= g, z <= b, w <= a)) {
        lessThanEqual(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
      expect(Vec4b(x > r, y > g, z > b, w > a)) {
        greaterThan(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
      expect(Vec4b(x >= r, y >= g, z >= b, w >= a)) {
        greaterThanEqual(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
      expect(Vec4b(x == r, y == g, z == b, w == a)) {
        equal(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
      expect(Vec4b(x != r, y != g, z != b, w != a)) {
        notEqual(Vec4i(x, y, z, w), Vec4i(r, g, b, a))
      }
    }

    for ((x, y, z, w, r, g, b, a, s, t, p, q) <- testData) {
      test(x, y, z, w,
         r, g, b, a,
         s, t, p, q)
    }

    setSeed(1)
    for (i <- 0 until 1000) {
      test(nextInt, nextInt, nextInt, nextInt,
         nextInt, nextInt, nextInt, nextInt,
         nextInt, nextInt, nextInt, nextInt)
    }
  }
}
