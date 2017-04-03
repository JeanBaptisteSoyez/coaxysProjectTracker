using CoaxysProjectTracker.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.Owin;
using Microsoft.Owin.Security;
using CoaxysProjectTracker.Services;

namespace CoaxysProjectTracker.Controllers
{
    [Authorize]
    public class AccountController : Controller
    {
        [AllowAnonymous]
        public ActionResult Login(string returnUrl)
        {
            ViewBag.ReturnUrl = returnUrl;
            return View();
        }

        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Login(LoginViewModel model, string returnUrl = "")
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            //TODO Remove mocks
            string service = "";
            if (model.Email.IndexOf("admin") != -1) service = "login1.json";
            if (model.Email.IndexOf("user") != -1) service = "login2.json";

            var user = await Api.PostAsync<User>(service, new {
                email = model.Email,
                password = model.Password
            });
            
            if (user != null)
            {
                var ident = new ClaimsIdentity(
                    new[] { 

                        // Support default antiforgery provider
                        new Claim(ClaimTypes.NameIdentifier, user.Email),
                        new Claim("http://schemas.microsoft.com/accesscontrolservice/2010/07/claims/identityprovider", "ASP.NET Identity", "http://www.w3.org/2001/XMLSchema#string"),
                        
                        new Claim(ClaimTypes.Email, user.Email),
                        new Claim(ClaimTypes.Name, user.Name),

                        // Add roles
                        //TODO Add roles dinamically
                        new Claim(ClaimTypes.Role, user.Role),
                        //new Claim(ClaimTypes.Role, "AnotherRole"),

                    },
                    DefaultAuthenticationTypes.ApplicationCookie
                );

                HttpContext.GetOwinContext().Authentication.SignIn(new AuthenticationProperties { IsPersistent = false }, ident);

                //TODO Handle multiple urls depending on roles?
                if(returnUrl != "")
                {
                    return Redirect(returnUrl);
                }

                return RedirectToAction("Index", "Home"); // auth succeed 
            }

            // invalid username or password
            ModelState.AddModelError("", "Tentative de connexion non valide.");
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Logout()
        {
            HttpContext.GetOwinContext().Authentication.SignOut(DefaultAuthenticationTypes.ApplicationCookie);
            return RedirectToAction("Index", "Home");
        }
    }
}