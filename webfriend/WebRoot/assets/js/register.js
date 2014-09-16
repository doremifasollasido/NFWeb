

$(function() 
{		  
	         $("#sub").bind("click",function(event){    
	    	    var username=$.trim($("#username").val()); 
	    	    var password=$.trim($("#password").val()); 
	    	    var repassword=$.trim($("#repassword").val()); 
	    	    var alais=$.trim($("#alais").val()); 
	    	    var sno=$.trim($("#sno").val()); 
	    	    var email=$.trim($("#email").val()); 
	    	    //用名验证
	             if(username.length<4||username.length>10)
	             {	            	
	            	 var instr="<span style='color:#C00;'>用户名长度应该在4-10位</span>";
	     			$("#us").html(instr);		
	     			event.preventDefault();
	             }     	      
	             else
	            {
	            	 $("#us").html("")
	            }    
	             //密码验证
	              if(password.length<4||password.length>10)
	             {	            	
	            	 var instr="<span style='color:#C00;'>密码长度应该在4-10位</span>";
	     			$("#pw").html(instr);		
	     			event.preventDefault();
	             }     	      
	             else
	            {
	            	 $("#pw").html("")
	            }   
	              //重复密码验证
	              if(password!=repassword)
	            {
	            	  var instr="<span style='color:#C00;'>密码不一致</span>";
		     			$("#rpw").html(instr);		
		     			event.preventDefault();
	            }
	              //昵称验证
	              if(alais.length<2||alais.length>10)
		             {	            	
		            	 var instr="<span style='color:#C00;'>昵称长度应该在2-10位</span>";
		     			$("#al").html(instr);		
		     			event.preventDefault();
		             }     	      
		             else
		            {
		            	 $("#al").html("")
		            }   
	              //学号
	              if(sno.length<2||sno.length>10)
		             {	            	
		            	 var instr="<span style='color:#C00;'>学号长度应该在2-10位</span>";
		     			$("#sn").html(instr);		
		     			event.preventDefault();
		             }     	      
		             else
		            {
		            	 $("#sn").html("")
		            }   
	              //邮箱验证
	         
	                 var pattern=new RegExp(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/);    //6-14位字母和数字组合的正则表达式
	      		      flag = pattern.test(email);
	               if (!flag)
		             {	            	
		            	 var instr="<span style='color:#C00;'>邮箱格式不正确</span>";
		     			$("#em").html(instr);		
		     			event.preventDefault();
		             }     	      
		             else
		            {
		            	 $("#em").html("")
		            }   
	         });
	               
	     
	
	
});