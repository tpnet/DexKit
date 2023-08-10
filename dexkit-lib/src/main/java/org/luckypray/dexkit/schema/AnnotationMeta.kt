// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.BaseVector
import com.google.flatbuffers.BooleanVector
import com.google.flatbuffers.ByteVector
import com.google.flatbuffers.Constants
import com.google.flatbuffers.DoubleVector
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.FloatVector
import com.google.flatbuffers.LongVector
import com.google.flatbuffers.StringVector
import com.google.flatbuffers.Struct
import com.google.flatbuffers.Table
import com.google.flatbuffers.UnionVector
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.sign

@Suppress("unused")
class AnnotationMeta : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : AnnotationMeta {
        __init(_i, _bb)
        return this
    }
    val dexId : UInt
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val typeId : UInt
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val typeDescriptor : String?
        get() {
            val o = __offset(8)
            return if (o != 0) {
                __string(o + bb_pos)
            } else {
                null
            }
        }
    val typeDescriptorAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 1)
    fun typeDescriptorInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
    val retentionPolicy : Byte
        get() {
            val o = __offset(10)
            return if(o != 0) bb.get(o + bb_pos) else 0
        }
    fun elements(j: Int) : AnnotationElementMeta? = elements(AnnotationElementMeta(), j)
    fun elements(obj: AnnotationElementMeta, j: Int) : AnnotationElementMeta? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val elementsLength : Int
        get() {
            val o = __offset(12); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsAnnotationMeta(_bb: ByteBuffer): AnnotationMeta = getRootAsAnnotationMeta(_bb, AnnotationMeta())
        fun getRootAsAnnotationMeta(_bb: ByteBuffer, obj: AnnotationMeta): AnnotationMeta {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createAnnotationMeta(builder: FlatBufferBuilder, dexId: UInt, typeId: UInt, typeDescriptorOffset: Int, retentionPolicy: Byte, elementsOffset: Int) : Int {
            builder.startTable(5)
            addElements(builder, elementsOffset)
            addTypeDescriptor(builder, typeDescriptorOffset)
            addTypeId(builder, typeId)
            addDexId(builder, dexId)
            addRetentionPolicy(builder, retentionPolicy)
            return endAnnotationMeta(builder)
        }
        fun startAnnotationMeta(builder: FlatBufferBuilder) = builder.startTable(5)
        fun addDexId(builder: FlatBufferBuilder, dexId: UInt) = builder.addInt(0, dexId.toInt(), 0)
        fun addTypeId(builder: FlatBufferBuilder, typeId: UInt) = builder.addInt(1, typeId.toInt(), 0)
        fun addTypeDescriptor(builder: FlatBufferBuilder, typeDescriptor: Int) = builder.addOffset(2, typeDescriptor, 0)
        fun addRetentionPolicy(builder: FlatBufferBuilder, retentionPolicy: Byte) = builder.addByte(3, retentionPolicy, 0)
        fun addElements(builder: FlatBufferBuilder, elements: Int) = builder.addOffset(4, elements, 0)
        fun createElementsVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startElementsVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endAnnotationMeta(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
