/*
 * XML Type:  EntitySource
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.EntitySource
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts.impl;

import org.apache.xmlbeans.StringEnumAbstractBase;

/**
 * An XML EntitySource(@http://schemas.microsoft.com/crm/2011/Contracts).
 *
 * This is an atomic type that is a restriction of com.microsoft.schemas.crm._2011.contracts.EntitySource.
 */
public class EntitySourceImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.microsoft.schemas.crm._2011.contracts.EntitySource
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
    
    public EntitySourceImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, false);
    }
    
    protected EntitySourceImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
}
