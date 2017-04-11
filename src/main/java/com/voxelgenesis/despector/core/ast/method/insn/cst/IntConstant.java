/*
 * The MIT License (MIT)
 *
 * Copyright (c) Despector <https://despector.voxelgenesis.com>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.voxelgenesis.despector.core.ast.method.insn.cst;

import static com.google.common.base.Preconditions.checkNotNull;

import com.voxelgenesis.despector.core.ast.signature.PrimativeTypeSignature;
import com.voxelgenesis.despector.core.ast.signature.TypeSignature;

/**
 * A constant int value.
 */
public class IntConstant extends Constant {

    private int cst;
    private IntFormat format = IntFormat.DECIMAL;

    public IntConstant(int val) {
        this.cst = val;
    }

    /**
     * Gets the constant value.
     */
    public int getConstant() {
        return this.cst;
    }

    /**
     * Sets the constant value.
     */
    public void setConstant(int cst) {
        this.cst = cst;
    }

    public IntFormat getFormat() {
        return this.format;
    }

    public void setFormat(IntFormat format) {
        this.format = checkNotNull(format, "format");
    }

    @Override
    public TypeSignature inferType() {
        return PrimativeTypeSignature.INT;
    }

    @Override
    public String toString() {
        return String.valueOf(this.cst);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntConstant)) {
            return false;
        }
        IntConstant cast = (IntConstant) obj;
        return this.cst == cast.cst;
    }

    @Override
    public int hashCode() {
        return this.cst;
    }

    /**
     * The format for an integer constant when emitted.
     */
    public static enum IntFormat {
        BINARY,
        OCTAL,
        DECIMAL,
        HEXADECIMAL
    }

}
