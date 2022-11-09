/*
 * XML Type:  QuickFindResult
 * Namespace: http://schemas.microsoft.com/xrm/2011/Contracts
 * Java type: com.microsoft.schemas.xrm._2011.contracts.QuickFindResult
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.contracts;


/**
 * An XML QuickFindResult(@http://schemas.microsoft.com/xrm/2011/Contracts).
 *
 * This is a complex type.
 */
public interface QuickFindResult extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(QuickFindResult.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("quickfindresult6962type");
    
    /**
     * Gets the "Data" element
     */
    com.microsoft.schemas.xrm._2011.contracts.EntityCollection getData();
    
    /**
     * Tests for nil "Data" element
     */
    boolean isNilData();
    
    /**
     * True if has "Data" element
     */
    boolean isSetData();
    
    /**
     * Sets the "Data" element
     */
    void setData(com.microsoft.schemas.xrm._2011.contracts.EntityCollection data);
    
    /**
     * Appends and returns a new empty "Data" element
     */
    com.microsoft.schemas.xrm._2011.contracts.EntityCollection addNewData();
    
    /**
     * Nils the "Data" element
     */
    void setNilData();
    
    /**
     * Unsets the "Data" element
     */
    void unsetData();
    
    /**
     * Gets the "ErrorCode" element
     */
    int getErrorCode();
    
    /**
     * Gets (as xml) the "ErrorCode" element
     */
    org.apache.xmlbeans.XmlInt xgetErrorCode();
    
    /**
     * True if has "ErrorCode" element
     */
    boolean isSetErrorCode();
    
    /**
     * Sets the "ErrorCode" element
     */
    void setErrorCode(int errorCode);
    
    /**
     * Sets (as xml) the "ErrorCode" element
     */
    void xsetErrorCode(org.apache.xmlbeans.XmlInt errorCode);
    
    /**
     * Unsets the "ErrorCode" element
     */
    void unsetErrorCode();
    
    /**
     * Gets the "QueryColumnSet" element
     */
    com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring getQueryColumnSet();
    
    /**
     * Tests for nil "QueryColumnSet" element
     */
    boolean isNilQueryColumnSet();
    
    /**
     * True if has "QueryColumnSet" element
     */
    boolean isSetQueryColumnSet();
    
    /**
     * Sets the "QueryColumnSet" element
     */
    void setQueryColumnSet(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring queryColumnSet);
    
    /**
     * Appends and returns a new empty "QueryColumnSet" element
     */
    com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring addNewQueryColumnSet();
    
    /**
     * Nils the "QueryColumnSet" element
     */
    void setNilQueryColumnSet();
    
    /**
     * Unsets the "QueryColumnSet" element
     */
    void unsetQueryColumnSet();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    static final class StaticFactory
    {
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult newInstance() {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QuickFindResult parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QuickFindResult) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        private StaticFactory() { } // No instance of this class allowed
    }
}
