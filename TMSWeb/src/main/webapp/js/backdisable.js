/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).keydown(function(e) {
    if (e.keyCode === 8) {
        var element = e.target.nodeName.toLowerCase();
        if ((element != 'input' && element != 'textarea') || $(e.target).attr("readonly")) {
            return false;
        }
    }
}); 