package com.cttdcds.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class TextFileHandler {
	protected final File textFile;
	protected Charset charset;

	public TextFileHandler(File textFile) {
		this.textFile = textFile;
	}

	public TextFileHandler(File textFile, Charset charset) {
		this.textFile = textFile;
		this.charset = charset;
	}

	public String readFile() throws IOException {
		return FileUtils.readFileToString(textFile, charset);
	}
}
