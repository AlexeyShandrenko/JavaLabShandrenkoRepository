function countLines(strtocount, cols) {
	var hard_lines = 1;
	var last = 0;
	while ( true ) {
		last = strtocount.indexOf("\n", last+1);
		hard_lines ++;
		/* if ( hard_lines == 35) break; */
		if ( last == -1 ) break;
		}
	var soft_lines = Math.ceil(strtocount.length / (cols-1));
	var hard = eval("hard_lines " + unescape("%3e") + "soft_lines;");
	if ( hard ) soft_lines = hard_lines;
	return soft_lines;
}

// функция вызывается при каждом нажатии клавиши в области ввода текста
function ResizeTextArea(the_form,min_rows) {
	the_form.rows = Math.max(min_rows,countLines(the_form.value,the_form.cols) +1);
}