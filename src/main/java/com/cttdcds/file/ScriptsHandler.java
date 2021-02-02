package com.cttdcds.file;

import java.io.File;
import java.nio.charset.Charset;

public class ScriptsHandler extends TextFileHandler {
	public ScriptsHandler(File textFile) {
		super(textFile);
	}

	public ScriptsHandler(File textFile, Charset charset) {
		super(textFile, charset);
	}
}
