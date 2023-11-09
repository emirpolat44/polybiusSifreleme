package sifreleme;
import java.util.*;

public class Sifreleme {
static char harfler[][] = {  {'a','b','c','d','e','f'} , {'g','h','i','j','k','l'} ,
                             {'m','n','o','p','q','r'} , {'ı','ö','ş','ğ','y','z'} ,
                             {'s','t','u','v','w','x'} };
	
	static String sifre(String metin)
	{
		StringBuilder encrypt = new StringBuilder();
		
		for(int i = 0 ; i<metin.length();i++)
		{
			if(Character.isLetter(metin.charAt(i)) ||
                           Character.isDigit(metin.charAt(i))  ) 
				
                            encrypt.append(numaralandir(metin.charAt(i)));
			else 
				encrypt.append(metin.charAt(i));
		}
		
		return encrypt.toString();
	}
        
        static String numaralandir(char harf)
	{
		for(int i=0;i<harfler.length;i++)
		{
			for(int j=0;j<harfler[0].length;j++)
			{
				if(harfler[i][j] == Character.toLowerCase(harf))
				{
					return (i+1)+""+(j+1);
				}
			}
		}
		return String.valueOf(harf);
	}
	
        static String sifrecoz(String metin) 
	{
		StringBuilder decrypt = new StringBuilder();
		
		for(int i=0;i<metin.length();i+=2)
		{
			if(Character.isDigit(metin.charAt(i)))
				decrypt.append(harflendir(Character.getNumericValue(metin.charAt(i)),Character.getNumericValue(metin.charAt(i+1))));
			else
			{
				decrypt.append(Character.toUpperCase(metin.charAt(i)));
				i--;
			}			
		}
		
		return decrypt.toString();
	}
        
        static char harflendir(int i,int j)
	{
		return harfler[i-1][j-1];
	}
                
    public static void main(String[] args) {
        
        System.out.print("\t\tPolybius Sifreleme Sistemi\t\t"
                    + "\n<1> Metin Sifreleme"
                    + "\n<2> Sifre Cozme"
                    + "\n<3> Cikis\n");
        
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Sifrelenecek ya da Cozulecek Metini girin :");
            String al = sc.nextLine();
            String metin = al;
            System.out.print("Seciminiz :");
            int secim = sc.nextInt();
            if (secim == 1){               
            String encrypt = sifre(metin);           
            System.out.println(encrypt);
            } else if (secim == 2){                   
            String decrypt = sifrecoz(metin);           
            System.out.println(decrypt);
            } else if (secim == 3) {
            break;
            }
            
        
        
        }
        
    }
    
}
