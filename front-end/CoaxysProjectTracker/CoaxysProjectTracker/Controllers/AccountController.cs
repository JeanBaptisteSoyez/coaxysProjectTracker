﻿using CoaxysProjectTracker.Models;
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
using CoaxysProjectTracker.Api;
using CoaxysProjectTracker.Entities;

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
            
            var user = await API.PostAsync<User>("login1.json", new {
                email = model.Email,
                password = model.Password
            });

            //TODO Get user from service
            //if (new UserManager().IsValid(username, password))
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
                        new Claim(ClaimTypes.Role, "Admin"),
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