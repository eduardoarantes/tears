package br.com.trgs.definition.groupby;

public interface ICalculatedColumnDefinition
{

   public abstract String getContent();

   public abstract String getRefId();

   public abstract String getId();

   public abstract String getType();

   public abstract String getConsolidator();

   public abstract String getDescription();

   public abstract String getFormat();

}