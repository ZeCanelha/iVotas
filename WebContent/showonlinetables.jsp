<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iVotas</title>
</head>

<style>
	#container {
  width: 450px;
}
#history {
  height: 180px;
  border: 1px solid #AACAAC;
  padding: 5px;
  font-family: Courier, monospace;
  font-size: .9em;
  overflow-y: scroll;
  width: 100%;
}
#history p {
  margin: 0;
  padding: 0;
}
</style>

<script type="text/javascript">
        var websocket = null;
        window.onload = function() { // URI = ws://10.16.0.165:8080/WebSocket/ws
            connect('ws://' + window.location.host + '/iVotas/ws');
            
        }
        function connect(host) { // connect to the host websocket
            if ('WebSocket' in window)
                websocket = new WebSocket(host);
            else if ('MozWebSocket' in window)
                websocket = new MozWebSocket(host);
            else {
                writeToHistory('Get a real browser which supports WebSocket.');
                return;
            }
            websocket.onopen    = onOpen; // set the event listeners below
            websocket.onclose   = onClose;
            websocket.onmessage = onMessage;
            websocket.onerror   = onError;
        }
        function onOpen(event) {
            writeToHistory('Connected to ' + window.location.host + '.');
            writeToHistory('Notificações instantâneas');
            
            
        }
        
        function onClose(event) {
            writeToHistory('WebSocket closed.');
            
        }
        
        function onMessage(message) { // print the received message
            writeToHistory(message.data);
        }
        
        function onError(event) {
            writeToHistory('WebSocket error (' + event.data + ').');
            
        }
        
        function doSend() {
           
        }
        function writeToHistory(text) {
            var history = document.getElementById('history');
            var line = document.createElement('p');
            line.style.wordWrap = 'break-word';
            line.innerHTML = text;
            history.appendChild(line);
            history.scrollTop = history.scrollHeight;
        }
    </script>
<body>
	<div id="container"><div id="history"></div></div>
	<p><a href="<s:url action="backpag" />">Página inicial</a></p>
</body>
</html>