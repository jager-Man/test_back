<?php 
error_reporting(0);
if (isset($_COOKIE["user"])){ 		//���Ի�ȡָ����Cookie�����������
	$visnum=intval($_COOKIE["user"]["num"])+1;		//��ԭ���ķ��ʴ�����1
	$expire=intval($_COOKIE["user"]["expire"]);		//��ȡ��Ч��
	//�����η���ʱ��д��Cookie
	setcookie("user[dt]",date("Y-m-d H:i:s"),time()+3600*$expire);	
	setcookie("user[num]",$visnum,time()+3600*$expire);	//�����η��ʴ���д��Cookie
	echo"��ӭ��:".$_COOKIE["user"]["NameWXH"];			//���Cookie������ֵ
	echo "<br/>��������".$visnum."�η��ʱ���վ";
	echo "<br/>���ϴη�������".$_COOKIE["user"]["dt"];
}
else			//û��Cookie����ʾ��¼����	
	echo '<html><body>
<div style="border:1px solid #06f; background:#bbdeff">
  <form method="post" action="WXH149-3-2.php" style="margin:4px;">
    <p>�ʺ�: <input name="NameWXH" type="text" size="12"></p>
    <p>����: <input name="PW149" type="password" size="12"></p>
    <p>����: <select name="Save">
        <option value="-1">������</option>
        <option value="7">����1��</option>
        <option value="30">����1��</option></select> 
		<input type="submit" value="�� ¼"></p>
  </form></div></body></html>'
 
  ?>