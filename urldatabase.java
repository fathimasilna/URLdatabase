import java.util.*;

class Database
{
  String url;
  int key;
  int count;
  static int key_now=0;

  Database(String url)//storeurl
  {
    this.url=url;
    this.key=key_now++;
    this.count=0;
  }

  public int getURL()
  {
    count++;
    return key;
  }

  public int countURL()
  {
    return count;
  }

  public static void list(Database []database,int n)
  {
    for(int i=0;i<n;i++)
    {
      System.out.println("{\"url\":\""+database[i].url+"\",\"key\":"+database[i].key+",\"count\":"+database[i].count+"}");
    }
  }

  public static int searchGet(Database []database,int n,String urlValue)
  {
    for(int i=0;i<n;i++)
    {
      if(urlValue.equals(database[i].url))
      {
        return database[i].getURL();
      }
    }
    return -1;
  }

  public static int searchCount(Database []database,int n,String urlValue)
  {
    for(int i=0;i<n;i++)
    {
      if(urlValue.equals(database[i].url))
      {
        return database[i].countURL();
      }
    }
    return -1;
  }

}


public class urldatabase
{
  public static void main(String []args)
  {
    Scanner input=new Scanner(System.in);
    Database []database=new Database[10000];
    int n=0;

    while(true)
    {
      String command=input.next();

      if(command.equals("storeurl"))
      {
        String url=input.next();
        database[n++]=new Database(url);
      }
      if(command.equals("get"))
      {
        String urlValue=input.next();
        System.out.println(Database.searchGet(database,n,urlValue));
      }
      if(command.equals("count"))
      {
        String urlValue=input.next();
        System.out.println(Database.searchCount(database,n,urlValue));
      }
      if(command.equals("list"))
      {
        Database.list(database,n);
      }

      if(command.equals("exit"))
      {
        break;
      }

    }
  }
}
