package br.com.trgs.definition.report;

/**
 * Class ReportParameterSql.
 * 
 * @version $Revision$ $Date$
 */
public class ReportParameterSql implements java.io.Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = -5409006915934435224L;

   /**
    * Field _key.
    */
   private String key;

   /**
    * Field _value.
    */
   private String value;

   /**
    * Field _sql.
    */
   private String sql;

   public ReportParameterSql( String key, String value, String sql )
   {
      super();
      this.key = key;
      this.value = value;
      this.sql = sql;
   }

   public static long getSerialversionuid()
   {
      return serialVersionUID;
   }

   public String getKey()
   {
      return key;
   }

   public String getValue()
   {
      return value;
   }

   public String getSql()
   {
      return sql;
   }

}
