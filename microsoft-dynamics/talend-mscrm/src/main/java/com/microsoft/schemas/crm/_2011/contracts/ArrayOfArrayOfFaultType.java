/*
 * XML Type:  ArrayOfArrayOfFaultType
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts;


/**
 * An XML ArrayOfArrayOfFaultType(@http://schemas.microsoft.com/crm/2011/Contracts).
 *
 * This is a complex type.
 */
public interface ArrayOfArrayOfFaultType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfArrayOfFaultType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("arrayofarrayoffaulttype5950type");
    
    /**
     * Gets array of all "ArrayOfFaultType" elements
     */
    com.microsoft.schemas.crm._2011.contracts.ArrayOfFaultType[] getArrayOfFaultTypeArray();
    
    /**
     * Gets ith "ArrayOfFaultType" element
     */
    com.microsoft.schemas.crm._2011.contracts.ArrayOfFaultType getArrayOfFaultTypeArray(int i);
    
    /**
     * Tests for nil ith "ArrayOfFaultType" element
     */
    boolean isNilArrayOfFaultTypeArray(int i);
    
    /**
     * Returns number of "ArrayOfFaultType" element
     */
    int sizeOfArrayOfFaultTypeArray();
    
    /**
     * Sets array of all "ArrayOfFaultType" element
     */
    void setArrayOfFaultTypeArray(com.microsoft.schemas.crm._2011.contracts.ArrayOfFaultType[] arrayOfFaultTypeArray);
    
    /**
     * Sets ith "ArrayOfFaultType" element
     */
    void setArrayOfFaultTypeArray(int i, com.microsoft.schemas.crm._2011.contracts.ArrayOfFaultType arrayOfFaultType);
    
    /**
     * Nils the ith "ArrayOfFaultType" element
     */
    void setNilArrayOfFaultTypeArray(int i);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ArrayOfFaultType" element
     */
    com.microsoft.schemas.crm._2011.contracts.ArrayOfFaultType insertNewArrayOfFaultType(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ArrayOfFaultType" element
     */
    com.microsoft.schemas.crm._2011.contracts.ArrayOfFaultType addNewArrayOfFaultType();
    
    /**
     * Removes the ith "ArrayOfFaultType" element
     */
    void removeArrayOfFaultType(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    static final class StaticFactory
    {
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType newInstance() {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfArrayOfFaultType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        private StaticFactory() { } // No instance of this class allowed
    }
}
