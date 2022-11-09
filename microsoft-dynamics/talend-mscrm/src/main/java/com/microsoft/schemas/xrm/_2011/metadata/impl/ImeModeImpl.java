/*
 * XML Type:  ImeMode
 * Namespace: http://schemas.microsoft.com/xrm/2011/Metadata
 * Java type: com.microsoft.schemas.xrm._2011.metadata.ImeMode
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.metadata.impl;

import org.apache.xmlbeans.StringEnumAbstractBase;

/**
 * An XML ImeMode(@http://schemas.microsoft.com/xrm/2011/Metadata).
 *
 * This is an atomic type that is a restriction of com.microsoft.schemas.xrm._2011.metadata.ImeMode.
 */
public class ImeModeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.microsoft.schemas.xrm._2011.metadata.ImeMode
{
    private static final long serialVersionUID = 1L;

    @Override
    public StringEnumAbstractBase enumValue() {
        return getEnumValue();
    }

    @Override
    public void set(StringEnumAbstractBase e) {
        setEnumValue(e);
    }
    
    public ImeModeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, false);
    }
    
    protected ImeModeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
}
