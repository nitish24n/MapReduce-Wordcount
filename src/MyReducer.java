import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	@Override
	public void reduce(Text key,Iterable<IntWritable> value,Context context) throws IOException, InterruptedException {
		IntWritable final_sum = new IntWritable();
		int sum = 0;
		for(IntWritable val : value) {
			sum += val.get();
		}
		final_sum.set(sum);
		context.write(key, final_sum);
	}

}
