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
		/* 78 */ YY_NOT_ACCEPT,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NOT_ACCEPT,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NOT_ACCEPT,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NOT_ACCEPT,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NOT_ACCEPT,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NOT_ACCEPT,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NOT_ACCEPT,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NOT_ACCEPT,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NOT_ACCEPT,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NOT_ACCEPT,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NOT_ACCEPT,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NOT_ACCEPT,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NOT_ACCEPT,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NOT_ACCEPT,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NOT_ACCEPT,
		/* 108 */ YY_NOT_ACCEPT,
		/* 109 */ YY_NOT_ACCEPT,
		/* 110 */ YY_NOT_ACCEPT,
		/* 111 */ YY_NOT_ACCEPT,
		/* 112 */ YY_NOT_ACCEPT,
		/* 113 */ YY_NOT_ACCEPT,
		/* 114 */ YY_NOT_ACCEPT,
		/* 115 */ YY_NOT_ACCEPT,
		/* 116 */ YY_NOT_ACCEPT,
		/* 117 */ YY_NOT_ACCEPT,
		/* 118 */ YY_NOT_ACCEPT,
		/* 119 */ YY_NOT_ACCEPT,
		/* 120 */ YY_NOT_ACCEPT,
		/* 121 */ YY_NOT_ACCEPT,
		/* 122 */ YY_NOT_ACCEPT,
		/* 123 */ YY_NOT_ACCEPT,
		/* 124 */ YY_NOT_ACCEPT,
		/* 125 */ YY_NOT_ACCEPT,
		/* 126 */ YY_NOT_ACCEPT,
		/* 127 */ YY_NOT_ACCEPT,
		/* 128 */ YY_NOT_ACCEPT,
		/* 129 */ YY_NOT_ACCEPT,
		/* 130 */ YY_NOT_ACCEPT,
		/* 131 */ YY_NOT_ACCEPT,
		/* 132 */ YY_NOT_ACCEPT,
		/* 133 */ YY_NOT_ACCEPT,
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
		/* 204 */ YY_NOT_ACCEPT,
		/* 205 */ YY_NOT_ACCEPT,
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
		/* 223 */ YY_NOT_ACCEPT,
		/* 224 */ YY_NOT_ACCEPT,
		/* 225 */ YY_NOT_ACCEPT,
		/* 226 */ YY_NOT_ACCEPT,
		/* 227 */ YY_NOT_ACCEPT,
		/* 228 */ YY_NO_ANCHOR,
		/* 229 */ YY_NOT_ACCEPT,
		/* 230 */ YY_NOT_ACCEPT,
		/* 231 */ YY_NO_ANCHOR,
		/* 232 */ YY_NOT_ACCEPT,
		/* 233 */ YY_NOT_ACCEPT,
		/* 234 */ YY_NOT_ACCEPT,
		/* 235 */ YY_NOT_ACCEPT,
		/* 236 */ YY_NOT_ACCEPT,
		/* 237 */ YY_NOT_ACCEPT,
		/* 238 */ YY_NOT_ACCEPT,
		/* 239 */ YY_NOT_ACCEPT,
		/* 240 */ YY_NOT_ACCEPT,
		/* 241 */ YY_NOT_ACCEPT,
		/* 242 */ YY_NOT_ACCEPT,
		/* 243 */ YY_NOT_ACCEPT,
		/* 244 */ YY_NOT_ACCEPT,
		/* 245 */ YY_NOT_ACCEPT,
		/* 246 */ YY_NOT_ACCEPT,
		/* 247 */ YY_NOT_ACCEPT,
		/* 248 */ YY_NOT_ACCEPT,
		/* 249 */ YY_NOT_ACCEPT,
		/* 250 */ YY_NOT_ACCEPT,
		/* 251 */ YY_NOT_ACCEPT,
		/* 252 */ YY_NOT_ACCEPT,
		/* 253 */ YY_NOT_ACCEPT,
		/* 254 */ YY_NOT_ACCEPT,
		/* 255 */ YY_NOT_ACCEPT,
		/* 256 */ YY_NOT_ACCEPT,
		/* 257 */ YY_NOT_ACCEPT,
		/* 258 */ YY_NOT_ACCEPT,
		/* 259 */ YY_NOT_ACCEPT,
		/* 260 */ YY_NO_ANCHOR,
		/* 261 */ YY_NOT_ACCEPT,
		/* 262 */ YY_NOT_ACCEPT,
		/* 263 */ YY_NOT_ACCEPT,
		/* 264 */ YY_NOT_ACCEPT,
		/* 265 */ YY_NOT_ACCEPT,
		/* 266 */ YY_NOT_ACCEPT,
		/* 267 */ YY_NOT_ACCEPT,
		/* 268 */ YY_NOT_ACCEPT,
		/* 269 */ YY_NOT_ACCEPT,
		/* 270 */ YY_NOT_ACCEPT,
		/* 271 */ YY_NOT_ACCEPT,
		/* 272 */ YY_NOT_ACCEPT,
		/* 273 */ YY_NOT_ACCEPT,
		/* 274 */ YY_NOT_ACCEPT,
		/* 275 */ YY_NOT_ACCEPT,
		/* 276 */ YY_NOT_ACCEPT,
		/* 277 */ YY_NOT_ACCEPT
	};
	private int yy_cmap[] = unpackFromString(1,130,
"66:9,65,64,66,65,63,66:18,65,12,66:4,10,66,4,5,3,1,13,2,16,66:4,61,66:7,9,1" +
"1,6,66:3,42,47,48,45,44,62,53,60,58,66,50,43,40,52,51,41,66,49,35,59,56,57," +
"55,66,54,66,14,66,15,66:3,18,21,34,38,24,27,36,32,19,66,46,23,17,20,22,33,6" +
"6,29,28,25,30,37,31,39,26,66,7,66,8,66:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,278,
"0,1:6,2,1:3,3,1:6,4,1:23,5,1:2,6,7,1:31,8,9,1,10,1,11,12,13,14,15,16,17,18," +
"19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43," +
"44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68," +
"69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93," +
"94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,1" +
"14,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132," +
"133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151" +
",152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,17" +
"0,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,1" +
"89,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205")[0];

	private int yy_nxt[][] = unpackFromString(206,67,
"1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,79,82,84,86,88,82,228,90,92,82,94" +
",96,260,82,98,82,100,102,231,82,104,82:2,106,82:22,18,80,19,82,-1:73,20,-1:" +
"70,21,-1:120,80,-1:18,165,-1:66,170,-1:66,183,-1:69,107,-1:65,78,-1:5,81,-1" +
":78,227,-1:63,229,-1:50,83,-1:2,85,-1:6,22,-1:64,23,-1:65,87,-1:73,24,-1:57" +
",89,-1:3,91,-1:62,232,-1:67,95,-1:15,230,-1:52,108,-1:70,97,-1:2,226,-1:54," +
"259,-1:64,99,-1:76,109,-1:63,101,-1:71,111,-1:68,258,-1:57,113,-1:73,103,-1" +
":54,114,-1:71,233,-1:64,237,-1:67,267,-1:73,117,-1:61,276,-1:62,25,-1:70,26" +
",-1:66,27,-1:66,121,-1:66,28,-1:70,29,-1:66,122,-1:63,238,-1:71,239,-1:59,1" +
"23,-1:62,240,-1:85,30,-1:54,125,-1:69,126,-1:57,129,-1:70,31,-1:66,32,-1:70" +
",33,-1:54,134,-1:75,34,-1:59,135,-1:80,35,-1:72,136,-1:62,36,-1:52,37,-1:80" +
",38,-1:68,39,-1:70,138,-1:46,40,-1:74,41,-1:63,139,-1:2,140,-1:5,141,-1,273" +
",-1,243,-1:8,142,242,-1:10,272,-1:31,268,-1:64,143,-1:68,144,-1:74,145,-1:6" +
"4,263,-1:56,246,-1:71,147,-1:65,148,-1:65,150,-1:84,156,157,-1:58,158,-1:73" +
",277,-1:43,159,-1:73,248,-1:63,160,-1:68,42,-1:68,43,-1:75,161,-1:50,162,-1" +
":77,249,-1:82,163,-1:46,44,-1:69,45,-1:62,166,-1:80,167,-1:74,169,-1:39,46," +
"-1:88,171,-1,172,173,-1,174,175,-1:4,176,-1:8,177,-1:22,178,-1:72,179,-1:85" +
",180,-1:53,181,-1:81,184,-1,185,-1,251,-1,186,-1,253,264,187,-1,188,-1:37,1" +
"89,-1:32,47,-1:66,48,-1:33,190,-1:32,49,-1:66,50,-1:33,191,-1:32,51,-1:33,1" +
"92,-1:32,52,-1:33,193,-1:32,53,-1:34,194,-1:60,54,-1:87,195,-1:47,252,-1:64" +
",55,-1:85,56,196,-1,197,-1,57,-1,198,-1:6,199,-1:52,265,-1:67,200,-1:72,202" +
",-1:77,254,-1:64,205,-1:69,58,-1:66,59,-1:66,60,-1:66,61,-1:66,62,-1:30,63," +
"-1:86,206,-1:45,207,-1:64,208,-1:63,270,-1:80,64,-1:89,210,-1:55,65,-1:63,2" +
"11,-1:68,256,-1:65,257,-1:74,213,-1:43,66,-1:65,215,-1:70,216,-1:85,67,-1:6" +
"0,68,-1:74,218,-1:73,221,-1:50,266,-1:43,69,-1:71,70,-1:61,71,-1:78,222,-1:" +
"87,223,-1:65,72,-1:65,224,-1:59,73,-1:47,74,-1:85,75,-1:77,76,-1:70,77,-1:2" +
"6,112,-1:83,119,-1:54,93,-1:64,120,-1:69,110,-1:66,105,-1:64,234,-1:61,235," +
"-1:72,127,-1:70,124,-1:63,128,-1:64,262,-1:62,130,-1:76,131,-1:57,133,-1:62" +
",137,-1:72,247,-1:68,146,-1:62,153,-1:71,149,-1:65,155,-1:65,152,-1:65,164," +
"-1:83,168,-1:51,182,-1:86,201,-1:47,255,-1:90,203,-1:75,212,-1:30,214,-1:88" +
",219,-1:65,220,-1:42,116,-1:83,236,-1:54,261,-1:67,115,-1:60,132,-1:72,151," +
"-1:85,204,-1:71,209,-1:61,225,-1:41,118,-1:83,269,-1:66,154,-1:66,217,-1:56" +
",241,-1:62,244,-1:68,245,-1:81,250,-1:63,271,-1:66,275,-1:49,274,-1:47");

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
						{/*reset pos to -1, if 0, otherwise line 1 starts at 0, rest start at 1 */ yychar=-1;}
					case -19:
						break;
					case 19:
						{ /* ignore white space. */ }
					case -20:
						break;
					case 20:
						{return new Symbol(sym.EQUAL,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.AND,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -22:
						break;
					case 22:
						{return new Symbol(sym.IF,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.INT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.NEW,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.MAIN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.BYTE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.ELSE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.TRUE,new SymbolValue(yyline+1, yychar+1, yytext(), 1));}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.THIS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.VOID,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.FALSE,new SymbolValue(yyline+1, yychar+1, yytext(), 0));}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.WHILE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.CLASS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.IMPORT,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.LEGNTH,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -36:
						break;
					case 36:
						{return new Symbol(sym.STATIC,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -37:
						break;
					case 37:
						{return new Symbol(sym.RETURN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -38:
						break;
					case 38:
						{return new Symbol(sym.PUBLIC,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -39:
						break;
					case 39:
						{return new Symbol(sym.STRING,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -40:
						break;
					case 40:
						{return new Symbol(sym.BOOLEAN,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -41:
						break;
					case 41:
						{return new Symbol(sym.EXTENDS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -42:
						break;
					case 42:
						{return new Symbol(sym.MEGGYTONE,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -43:
						break;
					case 43:
						{return new Symbol(sym.MEGGY,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -44:
						break;
					case 44:
						{return new Symbol(sym.MEGGYDELAY,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -45:
						break;
					case 45:
						{return new Symbol(sym.MEGGYCOLOR,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -46:
						break;
					case 46:
						{return new Symbol(sym.MEGGYBUTTON,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -47:
						break;
					case 47:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 36363));}
					case -48:
						break;
					case 48:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 48541));}
					case -49:
						break;
					case 49:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 54485));}
					case -50:
						break;
					case 50:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 32397));}
					case -51:
						break;
					case 51:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 61157));}
					case -52:
						break;
					case 52:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 40816));}
					case -53:
						break;
					case 53:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 45816));}
					case -54:
						break;
					case 54:
						{return new Symbol(sym.MEGGYSETPIXEL,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -55:
						break;
					case 55:
						{return new Symbol(sym.MEGGYGETPIXEL,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -56:
						break;
					case 56:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 2));}
					case -57:
						break;
					case 57:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 1));}
					case -58:
						break;
					case 58:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 34323));}
					case -59:
						break;
					case 59:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 51427));}
					case -60:
						break;
					case 60:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 57724));}
					case -61:
						break;
					case 61:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 38526));}
					case -62:
						break;
					case 62:
						{return new Symbol(sym.TONE_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 43243));}
					case -63:
						break;
					case 63:
						{return new Symbol(sym.MEGGYTONESTART,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -64:
						break;
					case 64:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 4));}
					case -65:
						break;
					case 65:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 1));}
					case -66:
						break;
					case 66:
						{return new Symbol(sym.MEGGYSETAUXLEDS,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -67:
						break;
					case 67:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 0));}
					case -68:
						break;
					case 68:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 5));}
					case -69:
						break;
					case 69:
						{return new Symbol(sym.MEGGYCHECKBUTTON,new SymbolValue(yyline+1, yychar+1, yytext()));}
					case -70:
						break;
					case 70:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 16));}
					case -71:
						break;
					case 71:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 8));}
					case -72:
						break;
					case 72:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 4));}
					case -73:
						break;
					case 73:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 7));}
					case -74:
						break;
					case 74:
						{return new Symbol(sym.BUTTON_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 32));}
					case -75:
						break;
					case 75:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 2));}
					case -76:
						break;
					case 76:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 3));}
					case -77:
						break;
					case 77:
						{return new Symbol(sym.COLOR_LITERAL,new SymbolValue(yyline+1, yychar+1, yytext(), 6));}
					case -78:
						break;
					case 79:
						{ System.err.println("Illegal character: "+yytext()); }
					case -79:
						break;
					case 80:
						{/*reset pos to -1, if 0, otherwise line 1 starts at 0, rest start at 1 */ yychar=-1;}
					case -80:
						break;
					case 82:
						{ System.err.println("Illegal character: "+yytext()); }
					case -81:
						break;
					case 84:
						{ System.err.println("Illegal character: "+yytext()); }
					case -82:
						break;
					case 86:
						{ System.err.println("Illegal character: "+yytext()); }
					case -83:
						break;
					case 88:
						{ System.err.println("Illegal character: "+yytext()); }
					case -84:
						break;
					case 90:
						{ System.err.println("Illegal character: "+yytext()); }
					case -85:
						break;
					case 92:
						{ System.err.println("Illegal character: "+yytext()); }
					case -86:
						break;
					case 94:
						{ System.err.println("Illegal character: "+yytext()); }
					case -87:
						break;
					case 96:
						{ System.err.println("Illegal character: "+yytext()); }
					case -88:
						break;
					case 98:
						{ System.err.println("Illegal character: "+yytext()); }
					case -89:
						break;
					case 100:
						{ System.err.println("Illegal character: "+yytext()); }
					case -90:
						break;
					case 102:
						{ System.err.println("Illegal character: "+yytext()); }
					case -91:
						break;
					case 104:
						{ System.err.println("Illegal character: "+yytext()); }
					case -92:
						break;
					case 106:
						{ System.err.println("Illegal character: "+yytext()); }
					case -93:
						break;
					case 228:
						{ System.err.println("Illegal character: "+yytext()); }
					case -94:
						break;
					case 231:
						{ System.err.println("Illegal character: "+yytext()); }
					case -95:
						break;
					case 260:
						{ System.err.println("Illegal character: "+yytext()); }
					case -96:
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
