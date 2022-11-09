/*
 * XML Type:  ArrayOfPrivilegeDepth
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts;


/**
 * An XML ArrayOfPrivilegeDepth(@http://schemas.microsoft.com/crm/2011/Contracts).
 *
 * This is a complex type.
 */
public interface ArrayOfPrivilegeDepth extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfPrivilegeDepth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("arrayofprivilegedepth9156type");
    
    /**
     * Gets array of all "PrivilegeDepth" elements
     */
    com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth.Enum[] getPrivilegeDepthArray();
    
    /**
     * Gets ith "PrivilegeDepth" element
     */
    com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth.Enum getPrivilegeDepthArray(int i);
    
    /**
     * Gets (as xml) array of all "PrivilegeDepth" elements
     */
    com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth[] xgetPrivilegeDepthArray();
    
    /**
     * Gets (as xml) ith "PrivilegeDepth" element
     */
    com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth xgetPrivilegeDepthArray(int i);
    
    /**
     * Returns number of "PrivilegeDepth" element
     */
    int sizeOfPrivilegeDepthArray();
    
    /**
     * Sets array of all "PrivilegeDepth" element
     */
    void setPrivilegeDepthArray(com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth.Enum[] privilegeDepthArray);
    
    /**
     * Sets ith "PrivilegeDepth" element
     */
    void setPrivilegeDepthArray(int i, com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth.Enum privilegeDepth);
    
    /**
     * Sets (as xml) array of all "PrivilegeDepth" element
     */
    void xsetPrivilegeDepthArray(com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth[] privilegeDepthArray);
    
    /**
     * Sets (as xml) ith "PrivilegeDepth" element
     */
    void xsetPrivilegeDepthArray(int i, com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth privilegeDepth);
    
    /**
     * Inserts the value as the ith "PrivilegeDepth" element
     */
    void insertPrivilegeDepth(int i, com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth.Enum privilegeDepth);
    
    /**
     * Appends the value as the last "PrivilegeDepth" element
     */
    void addPrivilegeDepth(com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth.Enum privilegeDepth);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "PrivilegeDepth" element
     */
    com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth insertNewPrivilegeDepth(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "PrivilegeDepth" element
     */
    com.microsoft.schemas.crm._2011.contracts.PrivilegeDepth addNewPrivilegeDepth();
    
    /**
     * Removes the ith "PrivilegeDepth" element
     */
    void removePrivilegeDepth(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    static final class StaticFactory
    {
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth newInstance() {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfPrivilegeDepth) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        private StaticFactory() { } // No instance of this class allowed
    }
}
