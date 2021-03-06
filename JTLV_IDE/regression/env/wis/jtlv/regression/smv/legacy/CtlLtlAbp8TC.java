package env.wis.jtlv.regression.smv.legacy;

import java.io.IOException;

import org.junit.Test;

import env.wis.jtlv.regression.smv.ParsingTestCase;

public class CtlLtlAbp8TC extends ParsingTestCase {
	public static final String filename = "./testcases/legacy/ctl-ltl/abp8.smv";

	public CtlLtlAbp8TC() {
		this(false);
	}

	public CtlLtlAbp8TC(boolean save_ref) {
		super("ctl_ltl_abp8", filename, save_ref);
	}
	
	@Test
	public void ctl_ltl_abp8() throws IOException {
		super.doParsingTest();
	}
}
