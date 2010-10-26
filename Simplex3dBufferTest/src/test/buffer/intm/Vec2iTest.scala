/*
 * Simplex3d, BufferTest package
 * Copyright (C) 2010, Simplex3d Team
 *
 * This file is part of Simplex3dBufferTest.
 *
 * Simplex3dBufferTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dBufferTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package test.buffer
package intm

import org.scalatest._
import simplex3d.math.intm._
import simplex3d.buffer._
import simplex3d.buffer.intm._

import Descriptors._
import FactoryTest._
import ApplyUpdateTest._


/**
 * @author Aleksey Nikiforov (lex)
 */
class Vec2iTest extends FunSuite {

  test("Factories") {
    testArrayFromSize(DataArray[Vec2i, SByte](_))
    testArrayFromData[Vec2i, SByte](DataArray[Vec2i, SByte](_))
    testBufferFromSize(DataBuffer[Vec2i, SByte](_))
    testBufferFromData(DataBuffer[Vec2i, SByte](_))
    testViewFromData(DataView[Vec2i, SByte](_, _, _))
    testReadBufferFromData(ReadDataBuffer[Vec2i, SByte](_))
    testReadViewFromData(ReadDataView[Vec2i, SByte](_, _, _))
    testArrayFromCollection[Vec2i, SByte]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, SByte](a: _*))
    testArrayFromCollection[Vec2i, SByte]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, SByte](a))
    testBufferFromCollection[Vec2i, SByte]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, SByte](a: _*))
    testBufferFromCollection[Vec2i, SByte]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, SByte](a))

    testArrayFromSize(DataArray[Vec2i, UByte](_))
    testArrayFromData[Vec2i, UByte](DataArray[Vec2i, UByte](_))
    testBufferFromSize(DataBuffer[Vec2i, UByte](_))
    testBufferFromData(DataBuffer[Vec2i, UByte](_))
    testViewFromData(DataView[Vec2i, UByte](_, _, _))
    testReadBufferFromData(ReadDataBuffer[Vec2i, UByte](_))
    testReadViewFromData(ReadDataView[Vec2i, UByte](_, _, _))
    testArrayFromCollection[Vec2i, UByte]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, UByte](a: _*))
    testArrayFromCollection[Vec2i, UByte]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, UByte](a))
    testBufferFromCollection[Vec2i, UByte]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, UByte](a: _*))
    testBufferFromCollection[Vec2i, UByte]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, UByte](a))

    testArrayFromSize(DataArray[Vec2i, SShort](_))
    testArrayFromData[Vec2i, SShort](DataArray[Vec2i, SShort](_))
    testBufferFromSize(DataBuffer[Vec2i, SShort](_))
    testBufferFromData(DataBuffer[Vec2i, SShort](_))
    testViewFromData(DataView[Vec2i, SShort](_, _, _))
    testReadBufferFromData(ReadDataBuffer[Vec2i, SShort](_))
    testReadViewFromData(ReadDataView[Vec2i, SShort](_, _, _))
    testArrayFromCollection[Vec2i, SShort]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, SShort](a: _*))
    testArrayFromCollection[Vec2i, SShort]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, SShort](a))
    testBufferFromCollection[Vec2i, SShort]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, SShort](a: _*))
    testBufferFromCollection[Vec2i, SShort]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, SShort](a))

    testArrayFromSize(DataArray[Vec2i, UShort](_))
    testArrayFromData[Vec2i, UShort](DataArray[Vec2i, UShort](_))
    testBufferFromSize(DataBuffer[Vec2i, UShort](_))
    testBufferFromData(DataBuffer[Vec2i, UShort](_))
    testViewFromData(DataView[Vec2i, UShort](_, _, _))
    testReadBufferFromData(ReadDataBuffer[Vec2i, UShort](_))
    testReadViewFromData(ReadDataView[Vec2i, UShort](_, _, _))
    testArrayFromCollection[Vec2i, UShort]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, UShort](a: _*))
    testArrayFromCollection[Vec2i, UShort]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, UShort](a))
    testBufferFromCollection[Vec2i, UShort]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, UShort](a: _*))
    testBufferFromCollection[Vec2i, UShort]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, UShort](a))

    testArrayFromSize(DataArray[Vec2i, SInt](_))
    testArrayFromData[Vec2i, SInt](DataArray[Vec2i, SInt](_))
    testBufferFromSize(DataBuffer[Vec2i, SInt](_))
    testBufferFromData(DataBuffer[Vec2i, SInt](_))
    testViewFromData(DataView[Vec2i, SInt](_, _, _))
    testReadBufferFromData(ReadDataBuffer[Vec2i, SInt](_))
    testReadViewFromData(ReadDataView[Vec2i, SInt](_, _, _))
    testArrayFromCollection[Vec2i, SInt]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, SInt](a: _*))
    testArrayFromCollection[Vec2i, SInt]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, SInt](a))
    testBufferFromCollection[Vec2i, SInt]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, SInt](a: _*))
    testBufferFromCollection[Vec2i, SInt]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, SInt](a))

    testArrayFromSize(DataArray[Vec2i, UInt](_))
    testArrayFromData[Vec2i, UInt](DataArray[Vec2i, UInt](_))
    testBufferFromSize(DataBuffer[Vec2i, UInt](_))
    testBufferFromData(DataBuffer[Vec2i, UInt](_))
    testViewFromData(DataView[Vec2i, UInt](_, _, _))
    testReadBufferFromData(ReadDataBuffer[Vec2i, UInt](_))
    testReadViewFromData(ReadDataView[Vec2i, UInt](_, _, _))
    testArrayFromCollection[Vec2i, UInt]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, UInt](a: _*))
    testArrayFromCollection[Vec2i, UInt]((a: IndexedSeq[ReadVec2i]) => DataArray[Vec2i, UInt](a))
    testBufferFromCollection[Vec2i, UInt]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, UInt](a: _*))
    testBufferFromCollection[Vec2i, UInt]((a: IndexedSeq[ReadVec2i]) => DataBuffer[Vec2i, UInt](a))
  }

  test("Apply/Update") {
    testApplyUpdateArray[Vec2i, SByte](DataArray[Vec2i, SByte](_))
    testApplyUpdateBuffer(DataBuffer[Vec2i, SByte](_))
    testApplyUpdateView(DataView[Vec2i, SByte](_, _, _))
    
    testApplyUpdateArray[Vec2i, UByte](DataArray[Vec2i, UByte](_))
    testApplyUpdateBuffer(DataBuffer[Vec2i, UByte](_))
    testApplyUpdateView(DataView[Vec2i, UByte](_, _, _))
    
    testApplyUpdateArray[Vec2i, SShort](DataArray[Vec2i, SShort](_))
    testApplyUpdateBuffer(DataBuffer[Vec2i, SShort](_))
    testApplyUpdateView(DataView[Vec2i, SShort](_, _, _))
    
    testApplyUpdateArray[Vec2i, UShort](DataArray[Vec2i, UShort](_))
    testApplyUpdateBuffer(DataBuffer[Vec2i, UShort](_))
    testApplyUpdateView(DataView[Vec2i, UShort](_, _, _))
    
    testApplyUpdateArray[Vec2i, SInt](DataArray[Vec2i, SInt](_))
    testApplyUpdateBuffer(DataBuffer[Vec2i, SInt](_))
    testApplyUpdateView(DataView[Vec2i, SInt](_, _, _))
    
    testApplyUpdateArray[Vec2i, UInt](DataArray[Vec2i, UInt](_))
    testApplyUpdateBuffer(DataBuffer[Vec2i, UInt](_))
    testApplyUpdateView(DataView[Vec2i, UInt](_, _, _))
  }
}
