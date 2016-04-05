/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    
    $('#btn_menu_list').click( function () {               
        if($('#sidebar').hasClass('sidebar-active')){                      
            
            $('#sidebar').removeClass('sidebar-active').addClass('sidebar-inactive');                    
            $('#dynamic_content').removeClass('main-content').addClass('main-content-full');
                
        }else{
                    
            $('#sidebar').removeClass('sidebar-inactive').addClass('sidebar-active');                    
            $('#dynamic_content').removeClass('main-content-full').addClass('main-content');
                
        }            
    });
        
});          

