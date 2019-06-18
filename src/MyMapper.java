import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String strin[] = line.split(" ");
		IntWritable i = new IntWritable();
		i.set(1);
		Text keyWord = new Text();
		for(String s : strin) {
			String str = s.toUpperCase().trim();
			//words matching all the words ending with special characters
			if(str.matches("[A-Z,':.?]+")) {
				
				//7 digit words(6 digit + one special character at the end) ending 
				//with . or ? or other special characters
				if(str.matches("\\w+[.:;_,-]+(?= |$)") && str.length()-1 == 6) {
					keyWord.set(str.substring(0,str.length()-1));
					context.write(keyWord, i);
				}
				//6 digit words without special characters
				else if(str.matches("^[A-Z]+$") && str.length() == 6){
					keyWord.set(str);
					context.write(keyWord, i);
				}
			}		
		}
	}
}
