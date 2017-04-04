using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Threading.Tasks;
using CoaxysProjectTracker.Models;
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Attributes;
using CoaxysProjectTracker.Repositories;
using CoaxysProjectTracker.Extensions;

namespace CoaxysProjectTracker.Controllers
{
    [CustomAuthorize]
    public class StoryController : Controller
    {
        protected StoryRepository repository;

        public StoryController()
        {
            repository = new StoryRepository();
        }

        public async Task<ActionResult> Index()
        {
            var stories = await repository.GetStories();
            return View(stories);
        }
        
        public ActionResult Create()
        {
            return PartialView();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Story story)
        {
            Story resultStory = await repository.InsertStory(story);

            if(resultStory != null)
            {
                TempData.AddMessage((int)TempDataMessageType.Success, "La story a bien été créée.");
            }
            else
            {
                TempData.AddMessage((int)TempDataMessageType.Danger, "Un problème est survenu. La story n'a pas été créée.");
            }

            return RedirectToAction("index");
        }

        public async Task<ActionResult> Edit(int id)
        {
            var story = await repository.GetStoryByID(id);
            return PartialView(story);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(Story story)
        {
            Story resultStory = await repository.UpdateStory(story);

            if (resultStory != null)
            {
                TempData.AddMessage((int)TempDataMessageType.Success, "La story a bien été mise à jour.");
            }
            else
            {
                TempData.AddMessage((int)TempDataMessageType.Danger, "Un problème est survenu. La story n'a pas été mise à jour.");
            }

            return RedirectToAction("index");
        }
    }
}