package ai.libs.mlplan.examples.multiclass.sklearn;

import java.io.IOException;

import org.api4.java.ai.ml.core.dataset.serialization.DatasetDeserializationFailedException;
import org.api4.java.algorithm.exceptions.AlgorithmException;
import org.api4.java.algorithm.exceptions.AlgorithmExecutionCanceledException;
import org.api4.java.algorithm.exceptions.AlgorithmTimeoutedException;

import ai.libs.jaicore.ml.core.dataset.serialization.OpenMLDatasetReader;
import ai.libs.jaicore.ml.scikitwrapper.IScikitLearnWrapper;
import ai.libs.mlplan.sklearn.builder.MLPlanScikitLearnBuilder;

public class MLPlanScikitLearnMinimalExample {

	public static void main(final String[] args)
			throws AlgorithmTimeoutedException, AlgorithmException, InterruptedException, AlgorithmExecutionCanceledException, IOException, DatasetDeserializationFailedException {
		IScikitLearnWrapper c = MLPlanScikitLearnBuilder.forClassification().withDataset(new OpenMLDatasetReader().deserializeDataset(3)).build().call();
	}
}
