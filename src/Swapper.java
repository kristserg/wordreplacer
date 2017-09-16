import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Swapper 
{
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		System.out.println("Enter the word you want to replace: ");
		Scanner sc1 = new Scanner(System.in);
		String replacedWord = sc1.next();
		System.out.println("Enter the word you want to replace it with: ");
		String replacingWord = sc1.next();
		File f = new File("F:/Java/workspace/WordSwap/src/text.txt");
		@SuppressWarnings("resource")
		String content = new Scanner(f).useDelimiter("\\Z").next();
		content = content.replaceAll(replacedWord, replacingWord);
		String arr[] = content.split(" ");
		int i = 0;
		String temp = "";
		int code = 0;
		int end = 0;
		int begin = 0;
		boolean flag = false;
		while(i < arr.length)
		{
			//code = arr[i].codePointAt(0);
			for(int k = 0; k < arr[i].length(); k++)
			{
				code = arr[i].codePointAt(k);
				while(64 < code && code < 97 && end < arr[i].length())
				{
					if (flag = false)
					{
						begin = k;
					}
					flag = true;
					code = arr[i].codePointAt(end);
					end++;
				}
				if(flag == true)
				{
					break;
				}
				end = k;
			}
			temp = arr[i].toLowerCase();
			replacedWord = replacedWord.toLowerCase();
			if(temp.contains(replacedWord))
			{
				if (flag == true)
				{
					replacingWord = replacingWord.substring(begin, end - 1).toUpperCase() + replacingWord.substring(end - 1);
				}
				temp = temp.replace(replacedWord, replacingWord);
				arr[i] = temp;
			}
			i++;
			end = 1;
			flag = false;
		}
		String finalContent = "";
		for(int j = 0; j < arr.length; j++)
		{
			finalContent = finalContent + arr[j] + " ";
		}
		@SuppressWarnings("resource")
		PrintWriter pw = new PrintWriter(f, "UTF-8");
		pw.println(finalContent);
		pw.flush();
		sc1.close();
	}
}
