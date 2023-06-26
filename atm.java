package Atmm;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Atmprojet 
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
	    
    	 System.out.println("\n--------------- WELCOME TO SBI BANK ---------------\n");
    	 Class.forName("com.mysql.cj.jdbc.Driver");
	     String url = "jdbc:mysql://localhost:3306/atmc";
	     String user =  "root";
	     String pswd = "mysql123";
	     Connection con= DriverManager.getConnection(url,user,pswd);
         Scanner sc = new Scanner(System.in);
         int pi[]=new int[4];
		 int ba[] =new int[4];
		 Statement ss =   con.createStatement();
		 ResultSet rs = ss.executeQuery("select * from userinf;");
		 int g = 0;
		 while(rs.next())
		 {
			 ba[g]=rs.getInt(3);
			 pi[g]=rs.getInt(2);
			 g++;
		 }
//		
		 System.out.println("\n Use this AccountNumber and Pin \n ");
	 	 System.out.println(" 530021 ---- "+pi[0]);
		 System.out.println(" 530022 ---- "+pi[1]);
		 System.out.println(" 530023 ---- "+pi[2]);
		 System.out.println(" 530024 ---- "+pi[3]);
		
		 int ac[] = {530021,530022,530023,530024};
		// int pi[] = {1234,2341,3412,4321};
		
		
	//	  for(int f=0;f<=3;f++)
//		 {
//			 System.out.println(ba[f]+ " ");
//		 }
//		 
		 while(true)
       {
      	int n=-1;
      	System.out.print("\nEnter any of the above Account Number:");
			int accno = sc.nextInt();
			System.out.println( );
			PreparedStatement  s = con.prepareStatement("insert into user1 values(?,?,?,?);");
			PreparedStatement  s1 = con.prepareStatement("insert into user2 values(?,?,?,?);");
			PreparedStatement  s2 = con.prepareStatement("insert into user3 values(?,?,?,?);");
			PreparedStatement  s3 = con.prepareStatement("insert into user4 values(?,?,?,?);");
			 if(accno==ac[0])
           {
          	  n = 0;
          	  System.out.print("Enter the Pin:");
          	  int pn = sc.nextInt() ;  
          	  
          	  s.setInt(1, accno);
          	  if(pn==pi[n])
           	  {
           		  System.out.println("\n----------LOGIN SUCCESSFULL----------\n");
           	  }
           	  else
           	  {
           		  System.err.println("\nInvalid pin\n");
           		  continue;
           	  }
           }
			 else if(accno==ac[1])
           {
          	   n = 1;
          	  System.out.print("Enter the Pin:");
           	  int pn = sc.nextInt() ; 
           	  s1.setInt(1, accno);
           	  if(pn==pi[n])
           	  {
           		 System.out.println("\n----------LOGIN SUCCESSFULL----------\n");
           	  }
           	  else
           	  {
           		  System.err.println("\nInvalid pin\n");
           		  continue;
                }
          	   
            }
			  else if(accno==ac[2])
            {
          	  n = 2;
          	  System.out.print("Enter the Pin:");
           	  int pn = sc.nextInt() ;  
           	  s2.setInt(1, accno);
                if(pn==pi[n])
          	  {
              	  System.out.println("\n----------LOGIN SUCCESSFULL----------\n");
          	  }
          	  else
          	  {
          		  System.err.println("\nInvalid pin\n");
          		  continue;
          	  }
          	   
            }
			  else if(accno==ac[3])
            {
          	   n = 3;
          	  System.out.print("Enter the Pin:");
           	  int pn = sc.nextInt() ;
           	  s3.setInt(1, accno);
           	 if(pn==pi[n])
          	  {
           		 System.out.println("\n----------LOGIN SUCCESSFULL----------\n");
          	  }
          	  else
          	  {
          		  System.err.println("\nInvalid pin\n");
          		  continue;
          		  
          	  }
          	   
            }
           else
			 {
				System.err.println("\nInvalid Account");
				 continue;
		     }
			 
			 while(true)
           {
   	        System.out.println("\n1.Check the Balance:");
              System.out.println("2.Withdraw the amount:");
              System.out.println("3.Deposit the amount:");
              System.out.println("4.Change the pin:");
              System.out.println("5.Exit");
  	        System.out.print("\nChoose any one of the above action:");
              int i = sc.nextInt();
              switch(i)
              {
                  case 1:
                  	System.out.print("\nThe Balance is:");
	                    System.out.println(ba[n]);
		        	    break;
          	  
                  case 2:
                  	System.out.print("\nEnter the withdrawl amount:");
          	        int wd = sc.nextInt();
          	        if(n==0)
          	        {
          	        	 s.setInt(2, wd);
               	        s.setInt(3, 0);
          	        }
          	        if(n==1)
          	        {
          	        	 s1.setInt(2, wd);
               	         s1.setInt(3, 0);
          	        }
          	        if(n==2)
          	        {
          	        	 s2.setInt(2, wd);
               	         s2.setInt(3, 0);
          	        }
          	        if(n==3)
          	        {
          	        	 s3.setInt(2, wd);
               	         s3.setInt(3, 0);
          	        }
          	       
          	        if(wd<ba[n])
          	        {
          	        	System.out.println("\n----------Debited Successfully----------");
          		         ba[n] = ba[n]-wd;
           		         s.setInt(4, ba[n]);
          		         s1.setInt(4, ba[n]);
          		         s2.setInt(4,ba[n]);
          		         s3.setInt(4,ba[n]);
          		         if(n==0)
                        	  {
                        		 int row = s.executeUpdate();  
                        	     if(row>0)
                              {
                              	System.out.print("\n");
                              }
                              else
                              {
                              	System.out.println("Values inserted unsucess");
                              }
                        	  }
                      	
                       	  if(n==1)
                       	  {
                       		 int row = s1.executeUpdate();  
                       	     if(row>0)
                             {
                       	    	System.out.print("\n");
                             }
                             else
                             {
                             	System.out.println("Values inserted unsucess");
                             }
                       	  }
                       	 if(n==2)
                      	  {
                      		 int row = s2.executeUpdate();  
                      	     if(row>0)
                            {
                      	    	System.out.print("\n");
                            }
                            else
                            {
                            	System.out.println("Values inserted unsucess");
                            }
                      	  }
                       	 if(n==3)
                     	  {
                     		 int row = s3.executeUpdate();  
                     	     if(row>0)
                           {
                     	    	System.out.print("\n");
                           }
                           else
                           {
                           	System.out.println("Values inserted unsucess");
                           }
                     	  }
                        	
          		         PreparedStatement  pss = con.prepareStatement("update userinf set bal=? where acc=?;");
                           pss.setInt(1, ba[n]);
                           pss.setInt(2, ac[n]);
                           int rows = pss.executeUpdate();  
                    		  if(rows>0)
                    	      {
                    			  System.out.print("\n");
                    	      }
                    	      else
                    	      {
                    	      	System.out.println("Values updated unsucess");
                    	      }
                      }
          	        else
                	    {
                		  System.err.println("Insufficient Money");
                	    }
          	        break;
          	        
          	   case 3:
          		   System.out.print("\nEnter the Deposite amount:");
                     int da = sc.nextInt();
                     if(n==0)
                     {
                  	   s.setInt(2, 0);
                	        s.setInt(3, da);
                     }
                     if(n==1)
                     {
                  	   s1.setInt(2, 0);
                	        s1.setInt(3, da);
                     }
                     if(n==2)
                     {
                  	   s2.setInt(2, 0);
                	        s2.setInt(3, da);
                     }
                     if(n==3)
                     {
                  	   s3.setInt(2, 0);
                	        s3.setInt(3, da);
                     }
                     
                     ba[n]=ba[n]+da;
                     System.out.println("\n---------- Credited Successfully----------\n");
//                     System.out.print("\nYour balance is:");
//      		       System.out.println(ba[n]);
      		       PreparedStatement  pss = con.prepareStatement("update userinf set bal=? where acc=?;");
                     pss.setInt(1, ba[n]);
                     pss.setInt(2, ac[n]);
                     
                     int rows = pss.executeUpdate();  
              		  if(rows>0)
              	      {
              			System.out.print("\n");
              	      }
              	      else
              	      {
              	      	System.out.println("Values updated unsucess");
              	      }
      		       s.setInt(4, ba[n]);
      		       s1.setInt(4, ba[n]);
      		       s2.setInt(4, ba[n]);
      		       s3.setInt(4, ba[n]);
      		       
      		       if(n==0)
                  	  {
                  		 int row = s.executeUpdate();  
                  	     if(row>0)
                        {
                  	    	System.out.print("\n");
                        }
                        else
                        {
                        	System.out.println("Values inserted unsucess");
                        }
                  	  }
               
                 	  if(n==1)
                 	  {
                 		 int row = s1.executeUpdate();  
                 	     if(row>0)
                       {
                 	    	System.out.print("\n");
                       }
                       else
                       {
                       	System.out.println("Values inserted unsucess");
                       }
                 	  }
                 	 if(n==2)
                	  {
                		 int row = s2.executeUpdate();  
                	     if(row>0)
                      {
                	    	 System.out.print("\n");
                      }
                      else
                      {
                      	System.out.println("Values inserted unsucess");
                      }
                	  }
              	 if(n==3)
               	  {
               		 int row = s3.executeUpdate();  
               	     if(row>0)
                     {
               	    	System.out.print("\n");
                     }
                     else
                     {
                     	System.out.println("Values inserted unsucess");
                     }
               	  }
                 	
                  	
      		       
                  	
                     break;
          	   case 4:
          		   System.out.print("\nEnter Old pin:");
               	  int opin = sc.nextInt();
               	  if(opin == pi[n])
               	  {
               		  System.out.print("\nEnter New pin:");
                   	  int npin = sc.nextInt();
                   	  pi[n]=npin;
                   	 PreparedStatement  psss = con.prepareStatement("update userinf set pin=? where acc=?;");
                     psss.setInt(1, npin);
                     psss.setInt(2, ac[n]);
                     int rowss = psss.executeUpdate();  
           		  if(rowss>0)
           	      {
           			System.out.print("\n");
           	      }
           	      else
           	      {
           	      	System.out.println("Pin updated unsucess");
           	      }
             
                   	  System.out.println("\n----------Your Pin is updated----------");
                      }
               	  else
               	  {
               		  System.err.println("\nRecheck the pin");
               	  }
               	  break;
               	  
          	 case 5:
          		 System.out.println("\n-------------------Thankyou Visit Again----------------");
        	         System.exit(0);
          	default:
          	     System.err.println("\nEnter only any of the five ");
          	     break;
         }
         
     }
	}

	}
}
