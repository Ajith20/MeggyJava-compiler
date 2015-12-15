/*
  mj.lex
    Tokens/Symbols for MeggyJava language.
    NO dollars, but underscores anywhere in identifiers 
    (to avoid problems later when generating AVR labels from id-s)
    8 colors (not all the CPP colors)
    The values for the colors, buttons, and tones were found in
    MeggyJrSimple.h and MeggyJrSimple.cpp.
    Ignore single line comments: // until eol 
    ALSO: ignore C style comments, see http://ostermiller.org/findcomment.html
    Wim Bohm and Michelle Strout, 6/2011
*/
package mjparser;
import java_cup.runtime.Symbol;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NOT_ACCEPT,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NOT_ACCEPT,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NOT_ACCEPT,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NOT_ACCEPT,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NOT_ACCEPT,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NOT_ACCEPT,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NOT_ACCEPT,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NOT_ACCEPT,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NOT_ACCEPT,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NOT_ACCEPT,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NOT_ACCEPT,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NOT_ACCEPT,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NOT_ACCEPT,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NOT_ACCEPT,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NOT_ACCEPT,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NOT_ACCEPT,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NOT_ACCEPT,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NOT_ACCEPT,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NOT_ACCEPT,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NOT_ACCEPT,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NOT_ACCEPT,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NOT_ACCEPT,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NOT_ACCEPT,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NOT_ACCEPT,
		/* 135 */ YY_NOT_ACCEPT,
		/* 136 */ YY_NOT_ACCEPT,
		/* 137 */ YY_NOT_ACCEPT,
		/* 138 */ YY_NOT_ACCEPT,
		/* 139 */ YY_NOT_ACCEPT,
		/* 140 */ YY_NOT_ACCEPT,
		/* 141 */ YY_NOT_ACCEPT,
		/* 142 */ YY_NOT_ACCEPT,
		/* 143 */ YY_NOT_ACCEPT,
		/* 144 */ YY_NOT_ACCEPT,
		/* 145 */ YY_NOT_ACCEPT,
		/* 146 */ YY_NOT_ACCEPT,
		/* 147 */ YY_NOT_ACCEPT,
		/* 148 */ YY_NOT_ACCEPT,
		/* 149 */ YY_NOT_ACCEPT,
		/* 150 */ YY_NOT_ACCEPT,
		/* 151 */ YY_NOT_ACCEPT,
		/* 152 */ YY_NOT_ACCEPT,
		/* 153 */ YY_NOT_ACCEPT,
		/* 154 */ YY_NOT_ACCEPT,
		/* 155 */ YY_NOT_ACCEPT,
		/* 156 */ YY_NOT_ACCEPT,
		/* 157 */ YY_NOT_ACCEPT,
		/* 158 */ YY_NOT_ACCEPT,
		/* 159 */ YY_NOT_ACCEPT,
		/* 160 */ YY_NOT_ACCEPT,
		/* 161 */ YY_NOT_ACCEPT,
		/* 162 */ YY_NOT_ACCEPT,
		/* 163 */ YY_NOT_ACCEPT,
		/* 164 */ YY_NOT_ACCEPT,
		/* 165 */ YY_NOT_ACCEPT,
		/* 166 */ YY_NOT_ACCEPT,
		/* 167 */ YY_NOT_ACCEPT,
		/* 168 */ YY_NOT_ACCEPT,
		/* 169 */ YY_NOT_ACCEPT,
		/* 170 */ YY_NOT_ACCEPT,
		/* 171 */ YY_NOT_ACCEPT,
		/* 172 */ YY_NOT_ACCEPT,
		/* 173 */ YY_NOT_ACCEPT,
		/* 174 */ YY_NOT_ACCEPT,
		/* 175 */ YY_NOT_ACCEPT,
		/* 176 */ YY_NOT_ACCEPT,
		/* 177 */ YY_NOT_ACCEPT,
		/* 178 */ YY_NOT_ACCEPT,
		/* 179 */ YY_NOT_ACCEPT,
		/* 180 */ YY_NOT_ACCEPT,
		/* 181 */ YY_NOT_ACCEPT,
		/* 182 */ YY_NOT_ACCEPT,
		/* 183 */ YY_NOT_ACCEPT,
		/* 184 */ YY_NOT_ACCEPT,
		/* 185 */ YY_NOT_ACCEPT,
		/* 186 */ YY_NOT_ACCEPT,
		/* 187 */ YY_NOT_ACCEPT,
		/* 188 */ YY_NOT_ACCEPT,
		/* 189 */ YY_NOT_ACCEPT,
		/* 190 */ YY_NOT_ACCEPT,
		/* 191 */ YY_NOT_ACCEPT,
		/* 192 */ YY_NOT_ACCEPT,
		/* 193 */ YY_NOT_ACCEPT,
		/* 194 */ YY_NOT_ACCEPT,
		/* 195 */ YY_NOT_ACCEPT,
		/* 196 */ YY_NOT_ACCEPT,
		/* 197 */ YY_NOT_ACCEPT,
		/* 198 */ YY_NOT_ACCEPT,
		/* 199 */ YY_NOT_ACCEPT,
		/* 200 */ YY_NOT_ACCEPT,
		/* 201 */ YY_NOT_ACCEPT,
		/* 202 */ YY_NOT_ACCEPT,
		/* 203 */ YY_NOT_ACCEPT,
		/* 204 */ YY_NO_ANCHOR,
		/* 205 */ YY_NO_ANCHOR,
		/* 206 */ YY_NOT_ACCEPT,
		/* 207 */ YY_NOT_ACCEPT,
		/* 208 */ YY_NOT_ACCEPT,
		/* 209 */ YY_NOT_ACCEPT,
		/* 210 */ YY_NOT_ACCEPT,
		/* 211 */ YY_NOT_ACCEPT,
		/* 212 */ YY_NOT_ACCEPT,
		/* 213 */ YY_NOT_ACCEPT,
		/* 214 */ YY_NOT_ACCEPT,
		/* 215 */ YY_NOT_ACCEPT,
		/* 216 */ YY_NOT_ACCEPT,
		/* 217 */ YY_NOT_ACCEPT,
		/* 218 */ YY_NOT_ACCEPT,
		/* 219 */ YY_NOT_ACCEPT,
		/* 220 */ YY_NOT_ACCEPT,
		/* 221 */ YY_NOT_ACCEPT,
		/* 222 */ YY_NOT_ACCEPT,
		/* 223 */ YY_NO_ANCHOR,
		/* 224 */ YY_NOT_ACCEPT,
		/* 225 */ YY_NOT_ACCEPT,
		/* 226 */ YY_NOT_ACCEPT,
		/* 227 */ YY_NOT_ACCEPT,
		/* 228 */ YY_NOT_ACCEPT,
		/* 229 */ YY_NOT_ACCEPT,
		/* 230 */ YY_NO_ANCHOR,
		/* 231 */ YY_NOT_ACCEPT,
		/* 232 */ YY_NO_ANCHOR,
		/* 233 */ YY_NO_ANCHOR,
		/* 234 */ YY_NO_ANCHOR,
		/* 235 */ YY_NO_ANCHOR,
		/* 236 */ YY_NO_ANCHOR,
		/* 237 */ YY_NO_ANCHOR,
		/* 238 */ YY_NO_ANCHOR,
		/* 239 */ YY_NO_ANCHOR,
		/* 240 */ YY_NO_ANCHOR,
		/* 241 */ YY_NO_ANCHOR,
		/* 242 */ YY_NO_ANCHOR,
		/* 243 */ YY_NO_ANCHOR,
		/* 244 */ YY_NO_ANCHOR,
		/* 245 */ YY_NO_ANCHOR,
		/* 246 */ YY_NO_ANCHOR,
		/* 247 */ YY_NO_ANCHOR,
		/* 248 */ YY_NO_ANCHOR,
		/* 249 */ YY_NO_ANCHOR,
		/* 250 */ YY_NO_ANCHOR,
		/* 251 */ YY_NO_ANCHOR,
		/* 252 */ YY_NO_ANCHOR,
		/* 253 */ YY_NO_ANCHOR,
		/* 254 */ YY_NO_ANCHOR,
		/* 255 */ YY_NO_ANCHOR,
		/* 256 */ YY_NO_ANCHOR,
		/* 257 */ YY_NO_ANCHOR,
		/* 258 */ YY_NO_ANCHOR,
		/* 259 */ YY_NO_ANCHOR,
		/* 260 */ YY_NO_ANCHOR,
		/* 261 */ YY_NO_ANCHOR,
		/* 262 */ YY_NO_ANCHOR,
		/* 263 */ YY_NO_ANCHOR,
		/* 264 */ YY_NO_ANCHOR,
		/* 265 */ YY_NO_ANCHOR,
		/* 266 */ YY_NO_ANCHOR,
		/* 267 */ YY_NOT_ACCEPT,
		/* 268 */ YY_NOT_ACCEPT,
		/* 269 */ YY_NO_ANCHOR,
		/* 270 */ YY_NO_ANCHOR,
		/* 271 */ YY_NO_ANCHOR,
		/* 272 */ YY_NO_ANCHOR,
		/* 273 */ YY_NO_ANCHOR,
		/* 274 */ YY_NO_ANCHOR,
		/* 275 */ YY_NO_ANCHOR,
		/* 276 */ YY_NO_ANCHOR,
		/* 277 */ YY_NO_ANCHOR,
		/* 278 */ YY_NO_ANCHOR,
		/* 279 */ YY_NO_ANCHOR,
		/* 280 */ YY_NO_ANCHOR,
		/* 281 */ YY_NO_ANCHOR,
		/* 282 */ YY_NO_ANCHOR,
		/* 283 */ YY_NO_ANCHOR,
		/* 284 */ YY_NO_ANCHOR,
		/* 285 */ YY_NO_ANCHOR,
		/* 286 */ YY_NO_ANCHOR,
		/* 287 */ YY_NO_ANCHOR,
		/* 288 */ YY_NO_ANCHOR,
		/* 289 */ YY_NO_ANCHOR,
		/* 290 */ YY_NOT_ACCEPT,
		/* 291 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"68:9,71,69,68,71,70,68:18,67,12,68:4,10,68,4,5,3,1,13,2,16,64,63:3,61,63:6," +
"68,9,11,6,68:3,42,47,48,45,44,62,53,60,58,66,50,43,40,52,51,41,66,49,35,59," +
"56,57,55,66,54,66,14,68,15,68,65,68,18,21,34,38,24,27,36,32,19,66,46,23,17," +
"20,22,33,66,29,28,25,30,37,31,39,26,66,7,65,8,68:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,292,
"0,1:6,2,1:3,3,1:6,4,5,1:5,6,7,6:8,8,6:11,9,1:2,10,11,1:31,12,13,14,15,8,16," +
"1,17,1,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40" +
",41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65" +
",66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90" +
",91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111" +
",112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,13" +
"0,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,1" +
"49,150,151,152,153,154,155,156,157,6,158,159,160,161,162,163,164,165,166,16" +
"7,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,1" +
"86,187,188,189,190,6,191,192,193,194,195,196,197,198,199,200,201,202,203,20" +
"4,205,206,207,208,209,210,211,212,213,214,215")[0];

	private int yy_nxt[][] = unpackFromString(216,72,
"1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,266,85,204,275,266,277,279,280" +
",266,281,282,283,266,284,266,285,286,287,266,288,266:2,289,266:20,19,266,19" +
",84,266:2,20,89,21,86,20,-1:78,22,-1:75,23,-1:67,24,-1:10,266,223,266:5,230" +
",266:36,90,266,90,-1,232,266,83,-1:65,19,-1,19,-1:14,24,-1:10,266:44,90,266" +
",90,-1,232,266,83,-1:5,205,87,205:66,-1:2,205,-1,205:60,35,205,35,205:5,-1:" +
"2,205,-1:16,143,-1:71,148,-1:71,161,-1:61,24,-1:60,83,-1:7,88,-1:60,26,-1:1" +
"3,24,-1:10,233,266:2,93,266:6,25,266:33,90,266,90,-1,232,266,83,-1:73,21,-1" +
":3,88:2,92,88:68,-1:6,24,-1:10,90:47,-1:2,90,83,-1:5,88:2,92,88:60,91,88:7," +
"-1:6,24,-1:10,266:8,27,266:35,90,266,90,-1,232,266,83,-1:44,98,-1:37,24,-1:" +
"10,266:14,28,266:29,90,266,90,-1,232,266,83,-1:29,100,-1:2,206,-1:5,102,-1," +
"224,-1,231,-1:8,104,207,-1:10,267,-1:18,24,-1:10,266:3,29,266:40,90,266,90," +
"-1,232,266,83,-1:28,106,-1:53,24,-1:10,266:7,30,266:36,90,266,90,-1,232,266" +
",83,-1:26,108,-1:55,24,-1:10,266:7,31,266:36,90,266,90,-1,232,266,83,-1:36," +
"112,-1:45,24,-1:10,266:7,32,266:36,90,266,90,-1,232,266,83,-1:34,226,-1:47," +
"24,-1:10,266:11,33,266:32,90,266,90,-1,232,266,83,-1:40,208,-1:41,24,-1:10," +
"266:21,34,266:22,90,266,90,-1,232,266,83,-1:24,211,-1:57,24,-1:10,266:7,36," +
"266:36,90,266,90,-1,232,266,83,-1:29,116,-1:52,24,-1:10,266:7,37,266:36,90," +
"266,90,-1,232,266,83,-1:28,118,-1:53,24,-1:10,266:11,38,266:32,90,266,90,-1" +
",232,266,83,-1:27,122,-1:54,24,-1:9,94,266:44,90,266,90,-1,232,266,83,-1:45" +
",134,135,-1:35,24,-1:10,266:8,39,266:35,90,266,90,-1,232,266,83,-1:38,136,-" +
"1:43,24,-1:10,266:15,40,266:28,90,266,90,-1,232,266,83,-1:45,290,-1:36,24,-" +
"1:10,266:17,41,266:26,90,266,90,-1,232,266,83,-1:22,137,-1:59,24,-1:10,266:" +
"3,42,266:40,90,266,90,-1,232,266,83,-1:29,213,-1:52,24,-1:10,266:17,43,266:" +
"26,90,266,90,-1,232,266,83,-1:26,138,-1:55,24,-1:10,266:19,44,266:24,90,266" +
",90,-1,232,266,83,-1:28,47,-1:53,24,-1:9,96,266:44,90,266,90,-1,232,266,83," +
"-1:30,48,-1:51,24,-1:10,266:3,45,266:40,90,266,90,-1,232,266,83,-1:39,139,-" +
"1:42,24,-1:10,266:11,46,266:32,90,266,90,-1,232,266,83,-1:23,140,-1:82,214," +
"-1:87,141,-1:51,49,-1:74,50,-1:67,144,-1:85,145,-1:79,147,-1:44,51,-1:93,14" +
"9,-1,150,151,-1,152,153,-1:4,154,-1:8,155,-1:27,156,-1:77,157,-1:90,158,-1:" +
"58,159,-1:86,162,-1,163,-1,216,-1,164,-1,218,227,165,-1,166,-1:42,167,-1:32" +
",52,-1:71,53,-1:38,168,-1:32,54,-1:71,55,-1:38,169,-1:32,56,-1:38,170,-1:32" +
",57,-1:38,171,-1:32,58,-1:39,172,-1:65,59,-1:92,173,-1:52,217,-1:69,60,-1:9" +
"0,61,174,-1,175,-1,62,-1,176,-1:6,177,-1:57,228,-1:72,178,-1:77,180,-1:82,2" +
"19,-1:69,183,-1:74,63,-1:71,64,-1:71,65,-1:71,66,-1:71,67,-1:35,68,-1:91,18" +
"4,-1:50,185,-1:69,186,-1:68,225,-1:85,69,-1:94,188,-1:60,70,-1:68,189,-1:73" +
",221,-1:70,222,-1:79,191,-1:48,71,-1:70,193,-1:75,194,-1:90,72,-1:65,73,-1:" +
"79,196,-1:78,199,-1:55,229,-1:48,74,-1:76,75,-1:66,76,-1:83,200,-1:92,201,-" +
"1:70,77,-1:70,202,-1:64,78,-1:52,79,-1:90,80,-1:82,81,-1:75,82,-1:18,24,-1:" +
"10,266:7,95,266:36,90,266,90,-1,232,266,83,-1:5,205:68,-1:2,205,-1:24,110,-" +
"1:69,212,-1:85,130,-1:55,128,-1:76,120,-1:70,132,-1:70,126,-1:70,142,-1:88," +
"146,-1:56,160,-1:91,179,-1:52,220,-1:95,181,-1:80,190,-1:35,192,-1:93,197,-" +
"1:70,198,-1:34,24,-1:10,266:2,97,266:41,90,266,90,-1,232,266,83,-1:28,210,-" +
"1:83,195,-1:60,124,-1:90,182,-1:76,187,-1:66,203,-1:33,24,-1:10,266:19,269," +
"266:24,90,266,90,-1,232,266,83,-1:28,114,-1:53,24,-1:10,266:16,270,266:27,9" +
"0,266,90,-1,232,266,83,-1:10,24,-1:10,266:5,272,266:38,90,266,90,-1,232,266" +
",83,-1:10,24,-1:10,266:8,99,266:35,90,266,90,-1,232,266,83,-1:10,24,-1:10,2" +
"66:3,276,266:40,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:11,101,266:32,90" +
",266,90,-1,232,266,83,-1:10,24,-1:10,266:8,247,266:35,90,266,90,-1,232,266," +
"83,-1:10,24,-1:10,266:13,103,266:30,90,266,90,-1,232,266,83,-1:10,24,-1:10," +
"266:2,105,266:41,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:6,248,266:37,90" +
",266,90,-1,232,266,83,-1:10,24,-1:10,266,249,266:42,90,266,90,-1,232,266,83" +
",-1:10,24,-1:10,266:2,251,266:41,90,266,90,-1,232,266,83,-1:10,24,-1:10,266" +
":4,252,266:39,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:12,254,266:31,90,2" +
"66,90,-1,232,266,83,-1:10,24,-1:10,266:2,107,266:41,90,266,90,-1,232,266,83" +
",-1:10,24,-1:10,266:7,258,266:36,90,266,90,-1,232,266,83,-1:10,24,-1:10,266" +
":11,109,266:32,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:8,259,266:35,90,2" +
"66,90,-1,232,266,83,-1:10,24,-1:10,266:13,260,266:30,90,266,90,-1,232,266,8" +
"3,-1:10,24,-1:10,266:6,111,266:37,90,266,90,-1,232,266,83,-1:10,24,-1:10,26" +
"6:6,261,266:37,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:11,113,266:32,90," +
"266,90,-1,232,266,83,-1:10,24,-1:10,266:2,262,266:41,90,266,90,-1,232,266,8" +
"3,-1:10,24,-1:10,266:9,115,266:34,90,266,90,-1,232,266,83,-1:10,24,-1:10,26" +
"6:12,117,266:31,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:8,119,266:35,90," +
"266,90,-1,232,266,83,-1:10,24,-1:10,266:3,265,266:40,90,266,90,-1,232,266,8" +
"3,-1:10,24,-1:10,266:2,121,266:41,90,266,90,-1,232,266,83,-1:10,24,-1:10,26" +
"6:12,123,266:31,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:2,125,266:41,90," +
"266,90,-1,232,266,83,-1:10,24,-1:10,266:3,127,266:40,90,266,90,-1,232,266,8" +
"3,-1:10,24,-1:10,266:9,129,266:34,90,266,90,-1,232,266,83,-1:10,24,-1:10,26" +
"6,131,266:42,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:21,133,266:22,90,26" +
"6,90,-1,232,266,83,-1:26,209,-1:88,215,-1:38,24,-1:10,266:19,255,266:24,90," +
"266,90,-1,232,266,83,-1:10,24,-1:10,266:5,256,266:38,90,266,90,-1,232,266,8" +
"3,-1:10,24,-1:10,266:8,250,266:35,90,266,90,-1,232,266,83,-1:10,24,-1:10,26" +
"6:6,274,266:37,90,266,90,-1,232,266,83,-1:10,24,-1:10,266,253,266:42,90,266" +
",90,-1,232,266,83,-1:10,24,-1:10,266:7,264,266:36,90,266,90,-1,232,266,83,-" +
"1:10,24,-1:10,266:5,234,266:3,235,266:34,90,266,90,-1,232,266,83,-1:10,24,-" +
"1:10,266:19,257,266:24,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:7,236,266" +
":36,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:19,263,266:24,90,266,90,-1,2" +
"32,266,83,-1:10,24,-1:10,266:6,237,266:15,238,266:21,90,266,90,-1,232,266,8" +
"3,-1:10,24,-1:10,266:12,239,266:2,240,266:28,90,266,90,-1,232,266,83,-1:10," +
"24,-1:10,266,241,266:42,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:8,242,26" +
"6:35,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:7,271,266:36,90,266,90,-1,2" +
"32,266,83,-1:10,24,-1:10,266:15,243,266:28,90,266,90,-1,232,266,83,-1:10,24" +
",-1:10,266:13,244,266:30,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:6,273,2" +
"66:37,90,266,90,-1,232,266,83,-1:10,24,-1:10,266:8,245,266:35,90,266,90,-1," +
"232,266,83,-1:10,24,-1:10,266:5,246,266:38,90,266,90,-1,232,266,83,-1:10,24" +
",-1:10,266:7,291,266:36,90,266,90,-1,232,266,83,-1:23,268,-1:58,24,-1:10,26" +
"6:19,278,266:24,90,266,90,-1,232,266,83,-1:4");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return new Symbol(sym.EOF, new SymbolValue(yyline, yychar+1, "EOF"));
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return new Symbol(sym.PLUS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -3:
						break;
					case 3:
						{return new Symbol(sym.MINUS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -4:
						break;
					case 4:
						{return new Symbol(sym.TIMES,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.LPAREN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.RPAREN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -7:
						break;
					case 7:
						{return new Symbol(sym.ASSIGN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.LBRACE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.RBRACE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -10:
						break;
					case 10:
						{return new Symbol(sym.SEMI,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -11:
						break;
					case 11:
						{ System.err.println("Illegal character: "+yytext()); }
					case -12:
						break;
					case 12:
						{return new Symbol(sym.LT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.NOT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.COMMA,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -15:
						break;
					case 15:
						{return new Symbol(sym.LBRACKET,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -16:
						break;
					case 16:
						{return new Symbol(sym.RBRACKET,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -17:
						break;
					case 17:
						{return new Symbol(sym.DOT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -18:
						break;
					case 18:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -19:
						break;
					case 19:
						{return new Symbol(sym.INT_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), new Integer(yytext()))); }
					case -20:
						break;
					case 20:
						{ /* ignore white space. */ }
					case -21:
						break;
					case 21:
						{/*reset pos to -1, if 0, otherwise line 1 starts at 0, rest start at 1 */ yychar=-1;}
					case -22:
						break;
					case 22:
						{return new Symbol(sym.EQUAL,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.AND,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.ASSIG_ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -25:
						break;
					case 25:
						{return new Symbol(sym.IF,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -26:
						break;
					case 26:
						{ }
					case -27:
						break;
					case 27:
						{return new Symbol(sym.INT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.NEW,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.MAIN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.BYTE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.ELSE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.TRUE,new SymbolValue(yyline+1, yychar+1, yytext(),1));}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.THIS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.VOID,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.UMINUS,new SymbolValue(yyline+1, yychar+1, yytext(),new Integer(yytext())));}
					case -36:
						break;
					case 36:
						{return new Symbol(sym.FALSE,new SymbolValue(yyline+1, yychar+1, yytext(),0));}
					case -37:
						break;
					case 37:
						{return new Symbol(sym.WHILE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -38:
						break;
					case 38:
						{return new Symbol(sym.CLASS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -39:
						break;
					case 39:
						{return new Symbol(sym.IMPORT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -40:
						break;
					case 40:
						{return new Symbol(sym.LENGTH,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -41:
						break;
					case 41:
						{return new Symbol(sym.STATIC,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -42:
						break;
					case 42:
						{return new Symbol(sym.RETURN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -43:
						break;
					case 43:
						{return new Symbol(sym.PUBLIC,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -44:
						break;
					case 44:
						{return new Symbol(sym.STRING,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -45:
						break;
					case 45:
						{return new Symbol(sym.BOOLEAN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -46:
						break;
					case 46:
						{return new Symbol(sym.EXTENDS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -47:
						break;
					case 47:
						{return new Symbol(sym.MEGGYTONE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -48:
						break;
					case 48:
						{return new Symbol(sym.MEGGY,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -49:
						break;
					case 49:
						{return new Symbol(sym.MEGGYDELAY,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -50:
						break;
					case 50:
						{return new Symbol(sym.MEGGYCOLOR,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -51:
						break;
					case 51:
						{return new Symbol(sym.MEGGYBUTTON,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -52:
						break;
					case 52:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),36363));}
					case -53:
						break;
					case 53:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),48541));}
					case -54:
						break;
					case 54:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),54485));}
					case -55:
						break;
					case 55:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),32397));}
					case -56:
						break;
					case 56:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),61157));}
					case -57:
						break;
					case 57:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),40816));}
					case -58:
						break;
					case 58:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),45816));}
					case -59:
						break;
					case 59:
						{return new Symbol(sym.MEGGYSETPIXEL,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -60:
						break;
					case 60:
						{return new Symbol(sym.MEGGYGETPIXEL,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -61:
						break;
					case 61:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),2));}
					case -62:
						break;
					case 62:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),1));}
					case -63:
						break;
					case 63:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),34323));}
					case -64:
						break;
					case 64:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),51427));}
					case -65:
						break;
					case 65:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),57724));}
					case -66:
						break;
					case 66:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),38526));}
					case -67:
						break;
					case 67:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),43243));}
					case -68:
						break;
					case 68:
						{return new Symbol(sym.MEGGYTONESTART,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -69:
						break;
					case 69:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),4));}
					case -70:
						break;
					case 70:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),1));}
					case -71:
						break;
					case 71:
						{return new Symbol(sym.MEGGYSETAUXLEDS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -72:
						break;
					case 72:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),0));}
					case -73:
						break;
					case 73:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),5));}
					case -74:
						break;
					case 74:
						{return new Symbol(sym.MEGGYCHECKBUTTON,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -75:
						break;
					case 75:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),16));}
					case -76:
						break;
					case 76:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),8));}
					case -77:
						break;
					case 77:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),4));}
					case -78:
						break;
					case 78:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),7));}
					case -79:
						break;
					case 79:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),32));}
					case -80:
						break;
					case 80:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),2));}
					case -81:
						break;
					case 81:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),3));}
					case -82:
						break;
					case 82:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(),6));}
					case -83:
						break;
					case 84:
						{ System.err.println("Illegal character: "+yytext()); }
					case -84:
						break;
					case 85:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -85:
						break;
					case 86:
						{/*reset pos to -1, if 0, otherwise line 1 starts at 0, rest start at 1 */ yychar=-1;}
					case -86:
						break;
					case 87:
						{ }
					case -87:
						break;
					case 89:
						{ System.err.println("Illegal character: "+yytext()); }
					case -88:
						break;
					case 90:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -89:
						break;
					case 91:
						{ }
					case -90:
						break;
					case 93:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -91:
						break;
					case 95:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -92:
						break;
					case 97:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -93:
						break;
					case 99:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -94:
						break;
					case 101:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -95:
						break;
					case 103:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -96:
						break;
					case 105:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -97:
						break;
					case 107:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -98:
						break;
					case 109:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -99:
						break;
					case 111:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -100:
						break;
					case 113:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -101:
						break;
					case 115:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -102:
						break;
					case 117:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -103:
						break;
					case 119:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -104:
						break;
					case 121:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -105:
						break;
					case 123:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -106:
						break;
					case 125:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -107:
						break;
					case 127:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -108:
						break;
					case 129:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -109:
						break;
					case 131:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -110:
						break;
					case 133:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -111:
						break;
					case 204:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -112:
						break;
					case 205:
						{ }
					case -113:
						break;
					case 223:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -114:
						break;
					case 230:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -115:
						break;
					case 232:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -116:
						break;
					case 233:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -117:
						break;
					case 234:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -118:
						break;
					case 235:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -119:
						break;
					case 236:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -120:
						break;
					case 237:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -121:
						break;
					case 238:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -122:
						break;
					case 239:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -123:
						break;
					case 240:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -124:
						break;
					case 241:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -125:
						break;
					case 242:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -126:
						break;
					case 243:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -127:
						break;
					case 244:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -128:
						break;
					case 245:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -129:
						break;
					case 246:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -130:
						break;
					case 247:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -131:
						break;
					case 248:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -132:
						break;
					case 249:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -133:
						break;
					case 250:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -134:
						break;
					case 251:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -135:
						break;
					case 252:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -136:
						break;
					case 253:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -137:
						break;
					case 254:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -138:
						break;
					case 255:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -139:
						break;
					case 256:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -140:
						break;
					case 257:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -141:
						break;
					case 258:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -142:
						break;
					case 259:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -143:
						break;
					case 260:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -144:
						break;
					case 261:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -145:
						break;
					case 262:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -146:
						break;
					case 263:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -147:
						break;
					case 264:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -148:
						break;
					case 265:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -149:
						break;
					case 266:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -150:
						break;
					case 269:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -151:
						break;
					case 270:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -152:
						break;
					case 271:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -153:
						break;
					case 272:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -154:
						break;
					case 273:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -155:
						break;
					case 274:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -156:
						break;
					case 275:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -157:
						break;
					case 276:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -158:
						break;
					case 277:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -159:
						break;
					case 278:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -160:
						break;
					case 279:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -161:
						break;
					case 280:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -162:
						break;
					case 281:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -163:
						break;
					case 282:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -164:
						break;
					case 283:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -165:
						break;
					case 284:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -166:
						break;
					case 285:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -167:
						break;
					case 286:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -168:
						break;
					case 287:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -169:
						break;
					case 288:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -170:
						break;
					case 289:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -171:
						break;
					case 291:
						{return new Symbol(sym.ID,new SymbolValue(yyline+1, yychar+1, yytext())); }
					case -172:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
