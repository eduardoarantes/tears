package com.trgs.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import br.com.trgs.definition.report.IReportDefinition;

public class TreeViewMenuItem implements Serializable
{

   private static final long serialVersionUID = 1L;

   private String id;
   private String name;
   private String description;
   private Collection< TreeViewMenuItem > subItens;

   private List< IReportDefinition > folderReports;

   private Properties folderConfig;

   public String getId()
   {
      return id;
   }

   public void setId( String id )
   {
      this.id = id;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription( String description )
   {
      this.description = description;
   }

   public Collection< TreeViewMenuItem > getSubItens()
   {
      return subItens;
   }

   public void setSubItens( Collection< TreeViewMenuItem > subItens )
   {
      this.subItens = subItens;
   }

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( id == null )? 0: id.hashCode() );
      return result;
   }

   @Override
   public boolean equals( Object obj )
   {
      if( this == obj )
         return true;
      if( obj == null )
         return false;
      if( getClass() != obj.getClass() )
         return false;
      TreeViewMenuItem other = (TreeViewMenuItem) obj;
      if( id == null )
      {
         if( other.id != null )
            return false;
      }
      else if( !id.equals( other.id ) )
         return false;
      return true;
   }

   public void setReports( List< IReportDefinition > folderReports )
   {
      this.folderReports = folderReports;
   }

   public List< IReportDefinition > getReports()
   {
      return folderReports;
   }

   @Override
   public String toString()
   {
      return "TreeViewMenuItem [description=" + description + ", id=" + id + ", name=" + name + "]";
   }

   public void setFolderConfig( Properties folderConfig )
   {
      this.folderConfig = folderConfig;
   }

   public Properties getFolderConfig()
   {
      return folderConfig;
   }

   public TreeViewMenuItem clone()
   {
      TreeViewMenuItem item = new TreeViewMenuItem();
      item.setDescription( description );
      item.setId( id );
      item.setName( name );
      item.setReports( folderReports );
      item.setFolderConfig( folderConfig );
      item.setSubItens( subItens );

      return item;
   }

}
