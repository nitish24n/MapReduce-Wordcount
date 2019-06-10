import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
public class Count {

	public static void main(String[] args) throws IOException {
		if(args.length != 2) {
			System.err.println("Usage : WordCount <input dir path> <output dir path>");
			System.exit(-1);
		}
		
		Configuration c = new Configuration();
		Job job = new Job(c,"Word Count");
		job.setJarByClass(Count.class);
		
		
	}

}
