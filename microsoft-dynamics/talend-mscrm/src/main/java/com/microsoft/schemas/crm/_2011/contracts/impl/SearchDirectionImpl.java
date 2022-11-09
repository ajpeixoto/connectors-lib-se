/*
 * XML Type:  SearchDirection
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.SearchDirection
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts.impl;

import org.apache.xmlbeans.StringEnumAbstractBase;

/**
 * An XML SearchDirection(@http://schemas.microsoft.com/crm/2011/Contracts).
 *
 * This is an atomic type that is a restriction of com.microsoft.schemas.crm._2011.contracts.SearchDirection.
 */
public class SearchDirectionImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.microsoft.schemas.crm._2011.contracts.SearchDirection
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
    
    public SearchDirectionImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, false);
    }
    
    protected SearchDirectionImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
}
