$( document ).ready(function() {
    
    $("#email-submit").off('click').on('click',function(){
		let emails = $("#emailString").val();
        $.ajax({
            url: "/email/save/"+emails,
            type: "get",
            success: function(data) {
                console.log(data);
                let personid = data.id;
                if(typeof personid === 'undefined'){
					personid = data.ID;	
				}
				$('#PersonEmailId').html(personid);
                
                $('.login-Div').hide();
        		getAllNotes(personid);
            }
         });
    });
    
    
    $(".add-note").off('click').on('click',function(){
		$('#note-title').val('');
        $('#note-description').val('');
        $('.notes-Div').hide();
        $('.note-creation-Div').show();
        $('#add-note').show();
		$('#update-note').hide();
		$('#createNoteTitle').show();
		$('#updateNoteTitle').hide();
    });
    
    
    $("#add-note").off('click').on('click',function(){

        let title = $('#note-title').val();
        let desc = $('#note-description').val();
        let datetime = new Date().toLocaleString();
        let personid = $('#PersonEmailId').html();
        
        let jsonobj = {"noteTitle":title, "noteDescription":desc, "lastUpdatedDate":datetime, "email_Id":personid};
        console.log(jsonobj)
        
         $.ajax({
            url: "/note/save",
            type: "post",
            data: jsonobj,
            success: function(d) {
                console.log(d);
                $('.note-creation-Div').hide();
                let personid = $('#PersonEmailId').html();
                getAllNotes(personid);
            }
         });
    });
    
    function getAllNotes(personid){
		
		console.log(personid)
		
		$.ajax({
            url: "/note/getAll/"+personid,
            type: "get",
            success: function(data) {
                console.log(data);
                
                $('#AllNotes').html('');
                
      			data.forEach((currentElement, index) => {
	                let note = '<div class="col-lg-4 mb-3 d-flex align-items-stretch">'+
		            	'<div class="card notes-card">'+
		            		'<p style="display:none;">'+currentElement.ID+'</p>'+
							'<div class="card-header d-flex flex-column">'+
								'<h5 class="card-title">'+currentElement.NOTE_TITLE+'</h5>'+
							'</div>'+
		                    '<div class="card-body notes-card-body d-flex flex-column">'+
		                          '<p class="card-text mb-4">'+currentElement.NOTE_DESCRIPTION+'</p>'+
		                    '</div>'+
		                     '<div class="card-footer d-flex flex-row align-items-center justify-content-around" style="padding: 0;">'+
								'<div class="d-flex flex-row align-items-center" >'+
									'<i style="margin-right: 3px;" class="far fa-clock" ></i>'+
									'<p style="margin:0;">'+currentElement.LAST_UPDATED_DATE+'</p>'+
								'</div>'+
								'<div class="d-flex flex-row align-items-center justify-content-end">'+
									'<i class="fas fa-pen note-edit"></i>'+
									'<i class="fas fa-trash note-delete"></i>'+
								'</div>'+
		                    '</div>'+
		                '</div>'+
		            '</div>' 
		            $('#AllNotes').append(note);
	            });
            
        		$('.notes-Div').show();
            }
         });
	}
	
	$('#AllNotes').on('click', '.note-delete', function() {
	   let deleteid = $(this).parent().parent().parent().children('p').html();
	   console.log(deleteid);
	   
	   $.ajax({
            url: "/note/delete/"+deleteid,
            type: "delete",
            success: function(data) {
                console.log(data);
                let personid = $('#PersonEmailId').html();
                getAllNotes(personid);
            }
       });
	});
	
	$('#AllNotes').on('click', '.note-edit', function() {
	   let noteid = $(this).parent().parent().parent().children('p').html();
	   console.log(noteid);
	   
	    $.ajax({
            url: "/note/get/"+noteid,
            type: "get",
            success: function(data) {
                console.log(data);
                $('#note-title').val(data.noteTitle);
		        $('#note-description').val(data.noteDescription);
		        $('#updatedPersonid').html(data.id);
		        $('.notes-Div').hide();
		        $('#add-note').hide();
		        $('#update-note').show();
		        $('#createNoteTitle').hide();
				$('#updateNoteTitle').show();
		        $('.note-creation-Div').show();
            }
         });
	});
	
	$("#update-note").off('click').on('click',function(){

        let title = $('#note-title').val();
        let desc = $('#note-description').val();
        let datetime = new Date().toLocaleString();
        let personid = $('#PersonEmailId').html();
        let noteid = $('#updatedPersonid').html();
        
        let jsonobj = {"noteTitle":title, "noteDescription":desc, "lastUpdatedDate":datetime, "email_Id":personid};
        console.log(jsonobj)
        
         $.ajax({
            url: "/note/update/"+noteid,
            type: "get",
            data: jsonobj,
            success: function(d) {
                console.log(d);
                $('.note-creation-Div').hide();
                getAllNotes(personid);
            }
         });
    });


});