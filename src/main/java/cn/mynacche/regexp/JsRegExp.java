/*
 * Copyright 2013 The UTFoodPortalSE Project. Zhuhai Unitech Power Technology Co.,Ltd. All Rights Reserved.
 */

package cn.mynacche.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mynacche
 * @date 2013-9-16
 */
public class JsRegExp {

	public static String replaceFirst(String target, String regexp, String replacement) {

		return Pattern.compile(regexp).matcher(target).replaceFirst(replacement);
	}

	public static String replaceFirst(String target, String regexp, Rpl replacement) {

		Matcher m = Pattern.compile(regexp).matcher(target);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		if (result) {
			int count = m.groupCount();
			String[] $ = new String[count + 1];
			for (int i = 0; i <= count; i++) {
				$[i] = (m.group(i));
			}
			m.appendReplacement(sb, replacement.fn($));
		}

		m.appendTail(sb);

		return sb.toString();
	}
	/**
	 * 不支持组匹配和$占位符
	 */
	public static String replaceLast(String target, String regexp, String replacement) {

		Matcher m = Pattern.compile(regexp).matcher(target);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		int lastPos = 0;
		while (result) {
			int pos = m.end();
			result = m.find();
			if (!result) {
				m.find(lastPos);
				m.appendReplacement(sb, replacement);
			} else {
				lastPos = pos;
			}
		}
		m.appendTail(sb);

		return sb.toString();
	}
	
	public static String replaceLast(String target, String regexp, Rpl replacement) {

		Matcher m = Pattern.compile(regexp).matcher(target);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		int lastPos = 0;
		while (result) {
			int pos = m.end();
			result = m.find();
			if (!result) {
				m.find(lastPos);
				int count = m.groupCount();
				String[] $ = new String[count + 1];
				for (int i = 0; i <= count; i++) {
					$[i] = (m.group(i));
				}
				m.appendReplacement(sb, replacement.fn($));
			} else {
				lastPos = pos;
			}
		}
		m.appendTail(sb);

		return sb.toString();
	}

	public static String replaceAll(String target, String regexp, String replacement) {

		return Pattern.compile(regexp).matcher(target).replaceAll(replacement);
	}

	public static String replaceAll(String target, String regexp, Rpl replacement) {

		Matcher m = Pattern.compile(regexp).matcher(target);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		while (result) {
			int count = m.groupCount();
			String[] $ = new String[count + 1];
			for (int i = 0; i <= count; i++) {
				$[i] = (m.group(i));
			}
			m.appendReplacement(sb, replacement.fn($));
			result = m.find();
		}
		m.appendTail(sb);

		return sb.toString();
	}
}
